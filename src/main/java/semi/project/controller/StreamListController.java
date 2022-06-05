package semi.project.controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.*;
import semi.project.service.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 스트림페이지 리스트 출력
 * 스트림 공지사항 입력
 * 수업페이지 리스트 출력
 * 주제 테이블 인서트까지
 * 알림창 리스트 출력
 * */

@Log4j
@Controller
@RequestMapping("list")
public class StreamListController {
    private TeacherService teacherService;
    private SubjectService subjectService;
    private ClassService classService;
    private BoardService boardService;
    private NoticeService noticeService;
    private StudentService studentService;
    private ThemeService themeService;
    private AlarmService alarmService;

    public StreamListController(
            TeacherService teacherService,
            SubjectService subjectService,
            ClassService classService,
            BoardService boardService,
            NoticeService noticeService,
            StudentService studentService,
            ThemeService themeService,
            AlarmService alarmService
    ){
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.classService = classService;
        this.boardService = boardService;
        this.noticeService = noticeService;
        this.studentService = studentService;
        this.themeService = themeService;
        this.alarmService = alarmService;
    }


    // 스트림 탭의 리스트(공지,과제,자료) 출력
    @GetMapping("/mystream.do")
    public String myStream(String sucode,HttpSession session,Model model) throws Exception {
        String tid = (String)session.getAttribute("loginOkTid");
        String sid = (String)session.getAttribute("loginOksid");

        if(sucode.equals("")) throw new Exception("sucode가 존재하지 않음");
        session.setAttribute("sucode", sucode); // key=sucode, value=sucode 세션에 셋팅

        if(tid!=null) { // tid가 null이 아니라는건 session에 tid 값이 존재(= 선생님이 로그인중)
            this.setTeacherDefaultInfo(tid, model);
        }else {
            this.setStudentDefaultInfo(sid, model);
        }

        List<SubjectVo> subList = subjectService.selectSubjectBySucodeList(sucode); //수업코드로 subject 테이블 호출
        List<BoardVo> boardList = boardService.selectBoardBySucode(sucode); //수업코드로 board 테이블 호출(테마 테이블 거쳐서)
        List<NoticeVo> noticeList = noticeService.selectNoticeBySucode(sucode); //수업코드로 공지테이블 호출
        model.addAttribute("subList",subList);
        model.addAttribute("boardList", boardList);
        model.addAttribute("noticeList", noticeList);
        return "content/stream";
    }

    // !!! 수업 탭의 리스트 출력(왼쪽 주제리스트, 중앙에 주제 안에 과제,자료)
    @GetMapping("/myclass.do")
    public String myClass(String sucode,
                          HttpSession session,
                          Model model) throws Exception {

        String tid = (String)session.getAttribute("loginOkTid");
        String sid = (String)session.getAttribute("loginOksid");

        if(sucode.equals("")) throw new Exception("sucode가 존재하지 않음");
        session.setAttribute("sucode", sucode); // key=sucode, value=sucode 세션에 셋팅

        if(tid!=null) {
            this.setTeacherDefaultInfo(tid, model);
        }else{
            this.setStudentDefaultInfo(sid, model);
        }

        List<SubjectVo> subList = subjectService.selectSubjectBySucodeList(sucode); //수업코드로 subject 테이블 호출
        List<BoardVo> boardList = boardService.selectBoardBySucode(sucode); //수업코드로 board 테이블 호출(테마 테이블 거쳐서)
        List<ThemeVo> thlist = themeService.selectThemeBySucode(sucode); //수업코드로 theme 테이블 호출
        model.addAttribute("subList",subList);
        model.addAttribute("blist",boardList);
        model.addAttribute("thlist",thlist);

        return "content/class";
    }

    // 공지입력기능
    @PostMapping("/notice.do")
    public String addNotice(HttpSession session, NoticeVo noticeVo){
        String tid = (String)session.getAttribute("loginOkTid");
        String sid = (String)session.getAttribute("loginOksid");
        String sucode = (String) session.getAttribute("sucode");

        noticeVo.setSucode(sucode);
        noticeVo.setNcontent(noticeVo.getNcontent());
        if(tid !=null){
            noticeVo.setTid(tid);
            noticeService.insertByTeacher(noticeVo);
        }else if(sid !=null){
            noticeVo.setSid(sid);
            noticeService.insertByStu(noticeVo);

        }
        return "redirect:mystream.do?sucode="+sucode;
    }

    //공지삭제기능
    @GetMapping("/noticeDel.do")
    public String noticeDel(long nseq, HttpSession session) {
        Object code = session.getAttribute("sucode");
        String sucode = (String) code;
        log.info("#noticeDel nseq: "+nseq);
        noticeService.deleteByNseqS(nseq);
        return "redirect:mystream.do?sucode="+sucode;
    }


    //주제만들기 기능
    @PostMapping("/theme.do") //주제 생성
    public String addTheme(HttpSession session, ThemeVo themeVo) {
        Object t = session.getAttribute("loginOkTid"); //선생님 만이 주제 추가 가능
        String tid = (String)t;
        Object s = session.getAttribute("sucode"); //세션에서 수업코드를 가져옴.
        String sucode = (String)s; // Object -> String

        String thcode=""; // 주제 코드를 담을 변수
        String fail = "fail";
        List<ThemeVo> tinfo = themeService.selectAllS(thcode);

        for(int j=0; j<1;){
            StudentRandom r = new StudentRandom();
            char[] num = r.ran();
            if(num==null){
                log.info("failed generate num");
                j=0;
            }else{
                for(int i=0; i<num.length;i++){
                    thcode += Character.toString(num[i]);
                }
                thcode = thcode.trim();
                log.info("#thcode" + thcode);
                boolean flag = themeService.chkThcode(thcode);
                if(flag==true){
                    themeVo.setThcode(thcode);
                    themeVo.setTid(tid);
                    themeVo.setSucode(sucode);
                    themeService.thinsertS(themeVo);
                    j = 1;
                }else{
                    log.info("retry generate num");
                    j=0;
                }
            }
        }
        return "redirect:../list/myclass.do?sucode="+sucode;
    }


    //알람??
    @GetMapping("/alarm.do")
    public ModelAndView streamAlarm(HttpSession session) {
        Object id = session.getAttribute("sid");
        String sid = (String)id;

        List<AlarmVo> alarmList =  alarmService.aselectBysidS(sid);

        System.out.println(alarmList);

        ModelAndView mv = new ModelAndView("content/stream","alarmList",alarmList);

        return mv;
    }







    ArrayList<SubjectVo> sInfo2Header(String sid){ //header.jsp에 학생 정보를 보내기 위한 메소드입니다

        List<String> sucodelist = classService.selectBySidS(sid);
        ArrayList<SubjectVo> t = new ArrayList<SubjectVo>();
        for(int i = 0;i<sucodelist.size();i++) {
            List<SubjectVo> list = subjectService.selectAllS(sucodelist.get(i));
            for(int j=0;j<list.size();j++) {
                t.add(list.get(j));
            }
        }
        return t;
    }


    private void setTeacherDefaultInfo(String tid, Model model){
        List<TeacherVo> tList= teacherService.selectTeacherByTid(tid);
        List<SubjectVo> tSubList = subjectService.selectSubjectByTid(tid);
        model.addAttribute("tSubList",tSubList);
        model.addAttribute("tList", tList);
        model.addAttribute("tLogin",tid);
    }

    private void setStudentDefaultInfo(String sid, Model model){
        List<StudentVo> sList = studentService.selectStudentBySid(sid);
        List<String> sucodeList = classService.selectSucodeBySid(sid);
        List<SubjectVo> sSubList = subjectService.selectAttendedSubject(sucodeList);
        model.addAttribute("sSubList",sSubList);
        model.addAttribute("sList", sList);
        model.addAttribute("sLogin",sid);
    }




}