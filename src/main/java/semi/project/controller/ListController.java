package semi.project.controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.*;
import semi.project.service.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 스트림페이지 리스트 출력
 * 스트림 공지사항 입력
 * 수업페이지 리스트 출력
 * 주제 테이블 인서트까지
 * 알림창 리스트 출력
 * */

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("list")
public class ListController {
    private TeacherService teacherService;
    private SubjectService subjectService;
    private ClassService classService;
    private BoardService boardService;
    private NoticeService noticeService;
    private StudentService studentService;
    private ThemeService themeService;
    private AlarmService alarmService;


    @GetMapping("/mystream.do") // 해당 과목의 자료, 과제 를 불러 오기 위해
    public ModelAndView mystream(String sucode, HttpSession session) {
        // jsp에서 sucode를 물고온다.
        Object id1 = session.getAttribute("loginOksid"); // session 에서 sid 값 불러오기
        Object id2 = session.getAttribute("loginOkTid"); // session 에서 tid 값 불러오기

        String sid = (String)id1; // DB에 넣어야 하니깐 String으로 형변환
        String tid = (String)id2;

        List<SubjectVo> subList = subjectService.selectAllS(sucode); //수업코드로 subject 테이블 호출
        List<BoardVo> boardList = boardService.selectBySucode(sucode); //수업코드로 board 테이블 호출(테마 테이블 거쳐서)
        List<NoticeVo> noticeList = noticeService.selectBySucode(sucode); //수업코드로 공지테이블 호출

        if(tid!=null) { // tid가 null이 아니라는건 session에 tid 값이 존재(= 선생님이 로그인중)


            /**
             * header(사이드바 등)에 subject의 데이타를 보냅니다
             */
            List<SubjectVo> list = subjectService.selectBytid(tid);
            List<TeacherVo> tlist = teacherService.tNameCkS(tid);

            session.setAttribute("sucode", sucode); // key=sucode, value=sucode 세션에 셋팅
            ModelAndView mv = new ModelAndView();
            mv.setViewName("content/stream");
            mv.addObject("tLogin",tid);
            mv.addObject("subList",subList);
            mv.addObject("boardList", boardList);
            mv.addObject("noticeList", noticeList);
            mv.addObject("tSubList", list);
            mv.addObject("tList", tlist);

            return mv;

        }else if(sid!=null) {

            List<StudentVo> slist = studentService.sNameCkS(sid);
            ArrayList<SubjectVo> t= sInfo2Header(sid);
            session.setAttribute("sucode", sucode);

            ModelAndView mv = new ModelAndView();
            mv.setViewName("content/stream");
            mv.addObject("sLogin",sid);
            mv.addObject("subList",subList);
            mv.addObject("boardList", boardList);
            mv.addObject("noticeList", noticeList);
            mv.addObject("sSubList",t);
            mv.addObject("sList", slist);
            return mv;
        }
        return null;
    }

    @GetMapping("/myclass.do") // !!! 수업 탭의 리스트 출력(왼쪽 주제리스트, 중앙에 주제 안에 과제,자료)
    public ModelAndView myclass(String sucode, HttpSession session) {
        // jsp에서 sucode를 물고온다.
        Object id1 = session.getAttribute("loginOksid"); // session 에서 sid 값 불러오기
        Object id2 = session.getAttribute("loginOkTid"); // session 에서 tid 값 불러오기
        Object code = session.getAttribute("sucode");
        String sid = (String)id1;
        String tid = (String)id2;
        String gaincode = (String)code;

        List<SubjectVo> subList = subjectService.selectAllS(gaincode); //수업코드로 subject 테이블 불러오기
        List<BoardVo> blist = boardService.boardSelectClassS(gaincode); //수업코드로 board 테이블 호출
        List<ThemeVo> thlist = themeService.selectAllClassS(gaincode); //수업코드로 theme 테이블 호출
        log.info("blist check"+blist);
        log.info("thlist check"+thlist);


        if(tid!=null) {
            log.info("#check sucode: "+gaincode);

            List<SubjectVo> list = subjectService.selectBytid(tid);
            List<TeacherVo> tlist = teacherService.tNameCkS(tid);

            session.setAttribute("sucode", gaincode); // key=sucode, value=sucode 세션에 셋팅
            ModelAndView mv = new ModelAndView();
            mv.setViewName("content/class");
            mv.addObject("tLogin",tid);
            mv.addObject("subList",subList); //header.jsp
            mv.addObject("tSubList", list); //header.jsp
            mv.addObject("tList", tlist); //header.jsp
            mv.addObject("blist",blist);
            mv.addObject("thlist",thlist);

            // 선생 과 학생을 구분 해야 하므로 key=tsucode 로 설정
            return mv;
        }else if(sid!=null) {

            /**
             * header.jsp에 데이터 보내기 위한 로직
             */
            List<StudentVo> slist = studentService.sNameCkS(sid);
            ArrayList<SubjectVo> t= sInfo2Header(sid);
            session.setAttribute("sucode", gaincode);

            ModelAndView mv = new ModelAndView();
            mv.setViewName("content/class");
            mv.addObject("sLogin",sid);
            mv.addObject("subList",subList); //class.jsp, header.jsp에서
            mv.addObject("sSubList",t); //header.jsp에서
            mv.addObject("sList", slist); //header.jsp에서
            mv.addObject("blist",blist);
            mv.addObject("thlist",thlist);

            return mv;
        }
        return null;
    }

    @PostMapping("/notice.do")
    public String addNotice(HttpSession session, NoticeVo noticeVo){
        Object teacher = session.getAttribute("loginOkTid");
        String tid = (String) teacher;
        Object student = session.getAttribute("loginOksid");
        String sid = (String) student;
        Object code = session.getAttribute("sucode");
        String sucode = (String) code;
        log.info("tid login"+tid+"sid"+sid+"sucode"+sucode);

        String ncontent = noticeVo.getNcontent();

        if(tid !=null){
            noticeVo.setTid(tid);
            noticeVo.setNcontent(ncontent);
            noticeVo.setSucode(sucode);
            noticeService.insertByTeacher(noticeVo);
        }else if(sid !=null){
            //noticeVo = new NoticeVo(-1, null, ncontent, null, sid, sucode);
            noticeVo.setSid(sid);
            noticeVo.setNcontent(ncontent);
            noticeVo.setSucode(sucode);
            noticeService.insertByStu(noticeVo);

        }
        return "redirect:mystream.do?sucode="+sucode;
    }

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


    @GetMapping("/alarm.do")
    public ModelAndView alarmlist(HttpSession session) {
        Object id = session.getAttribute("sid");
        String sid = (String)id;

        List<AlarmVo> list =  alarmService.aselectBysidS(sid);

        System.out.println(list);

        ModelAndView mv = new ModelAndView("test/alarm","list",list);

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




}