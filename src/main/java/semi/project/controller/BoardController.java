package semi.project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.*;
import semi.project.service.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 과제or자료 상세내용 페이지 출력
 * 학생일 경우 과제 제출 기능
 *
 * */

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("myboard")

public class BoardController {
    private TeacherService teacherService;
    private SubjectService subjectService;
    private ClassService classService;
    private BoardService boardService;
    private NoticeService noticeService;
    private StudentService studentService;
    private ThemeService themeService;
    private AlarmService alarmService;
    private FileUploadService fileUploadService;

    
    
    
    @GetMapping("/content.do") // 과제or자료를 눌렀을때
    public ModelAndView readBoard(String sucode, HttpSession session,long bseq, BoardVo boardVo) {
        Object id1 = session.getAttribute("loginOksid"); // session 에서 sid 값 불러오기
        Object id2 = session.getAttribute("loginOkTid"); // session 에서 tid 값 불러오기
        Object code = session.getAttribute("sucode");
        String sid = (String)id1;
        String tid = (String)id2;
        String gaincode = (String)code;
        log.info("#boadlist sid:"+sid+" seq: "+bseq);
        log.info("#boadlist tid:"+tid+" seq: "+bseq);
        List<SubjectVo> subList = subjectService.selectAllS(gaincode); //수업코드로 subject 테이블 불러오기

        if(tid != null){
            String tname = teacherService.tnameS(tid);
            List<SubjectVo> list = subjectService.selectBytid(tid);
            List<TeacherVo> tlist = teacherService.tNameCkS(tid);
            List<BoardVo> blist =  boardService.boardSelectBySeqS(bseq);
            log.info("bseq를 사용해서불러온"+blist);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("content/board");
            mv.addObject("tLogin",tid);
            mv.addObject("list", blist);
            mv.addObject("subList",subList); //header.jsp
            mv.addObject("tSubList", list); //header.jsp
            mv.addObject("tList", tlist); //header.jsp

        }else if(sid !=null){
            String writeTid = boardService.boardSelectTidS(bseq); // bseq를 이용해 선생님 아이디 불러옴
            log.info("writeTid"+writeTid);
            String tname = teacherService.tnameS(writeTid); // 불러온 tid를 이용해서 선생님 이름 불러옴
            List<BoardVo> list =  boardService.boardSelectBySeqS(bseq);
            log.info("bseq를 사용해서불러온"+list);


            List<StudentVo> slist = studentService.sNameCkS(sid);
            ArrayList<SubjectVo> t= sInfo2Header(sid);

            ModelAndView mv = new ModelAndView();
            mv.setViewName("content/board");
            mv.addObject("list", list);
            mv.addObject("tname",tname);
            mv.addObject("subList",subList); //class.jsp, header.jsp에서
            mv.addObject("sSubList",t); //header.jsp에서
            mv.addObject("sList", slist); //header.jsp에서

            return mv;

        }

        return null;
    }


    //기한이 없는(==수업자료) 행 인서트
    @PostMapping("/boardin.do")
    public String addBoard(ThemeVo themeVo, @RequestParam("themelist")String thcode,
                          HttpSession session, BoardVo boardVo, AlarmVo alarmVo, MultipartFile file) { //deadline이 없는 수업 자료 insert

        Object code = session.getAttribute("sucode");
        Object id = session.getAttribute("loginOkTid");
        String sucode = (String)code;
        String tid = (String)id;


        String ofname = file.getOriginalFilename();


        String suname = subjectService.selectSunameS(sucode); // 해당하는 과목코드를 이용해 과목 이름을 뽑아온다.
        String tname = teacherService.tnameS(tid); // session을 이용해서  과제를 제출한 선생님의 이름을 뽑아온다.
        String adivision = "B"; // 종류는 A or B 이므로 과제를 표현할때는 B 값을 넣기위한 세팅

        List<String> sidlist = classService.selectSidS(sucode); // 알림 기능을 위해 해당 수업 코드에 해당 하는 학생 id 리스트 로 뽑아 온다.

        //알림 기능 구현
        if(sidlist.size()>0) { // 만약 0 번째 주소에 값이 null 이 아니면 -> list 는 0번째 부터 들어 가니깐 0 != null 이라는건 학생이 한명 이상 존재 한다는 뜻!
            if(sidlist.get(0)!=null) {
                for(int i =0; i<sidlist.size();i++) { // 뽑아온 학생의 수만큼 반목문 수행.
                    alarmVo.setAtname(tname); // 선생님 이름
                    alarmVo.setAsuname(suname); // 과목명
                    alarmVo.setAdivision(adivision); // 종류
                    alarmVo.setSucode(sucode); // 과목 코드
                    alarmVo.setSid(sidlist.get(i)); // list 0번째 값부터 list의 크기만큼
                    alarmService.ainsertS(alarmVo); // Alarm Table에 insert 해준다.
                }
            }
        }

        if(!ofname.equals("")) {
            log.info("#ofname 넘어오냐?"+ofname);
            boardVo.setTid(tid);
            boardVo.setThcode(thcode);
            boardVo.setSucode(sucode);
            ofname = ofname.trim();
            String url = fileUploadService.saveStore(file, boardVo);
            log.info("#url: "+url);
            log.info("#thcode: "+boardVo.getThcode());
            boardService.insertBoardOkFileS(boardVo);
            return "redirect:../list/myclass.do?sucode="+sucode;
        }else {
            boardVo.setTid(tid);
            boardVo.setThcode(thcode);
            boardVo.setSucode(sucode);
            boardService.insertBoardNotFileS(boardVo);
            return "redirect:../list/myclass.do?sucode="+sucode;
        }
    }



    @PostMapping("/assignin.do")
    public String assignIn(ThemeVo themeVo, @RequestParam("themelist")String thcode,
                           HttpSession session, @RequestParam("rdeadline")String rdeadline, BoardVo boardVo,
                           AlarmVo alarmVo, MultipartFile file ) { // 알림 사용을 위해 AlarmVo 선언

        String ofname = file.getOriginalFilename();

        Object code = session.getAttribute("sucode"); Object id = session.getAttribute("tid");
        String sucode = (String)code; String tid = (String)id;

        String suname = subjectService.selectSunameS(sucode); // 해당하는 과목코드를 이용해 과목 이름을 뽑아온다.
        String tname = teacherService.tnameS(tid); // session을 이용해서  과제를 제출한 선생님의 이름을 뽑아온다.
        String adivision = "A"; // 종류는 A or B 이므로 과제를 표현할때는 A 값을 넣기위한 세팅

        List<String> sidlist = classService.selectSidS(sucode); // 해당 수업 코드에 해당 하는 학생 id 리스트 로 뽑아 온다.
        if(sidlist.get(0)!=null) { // 만약 0 번째 주소에 값이 null 이 아니면 -> list 는 0번째 부터 들어 가니깐 0 != null 이라는건 학생이 한명 이상 존재 한다는 뜻!
            for(int i =0; i<sidlist.size();i++) { // 뽑아온 학생의 수만큼 반목문 수행.
                alarmVo.setAtname(tname); // 선생님 이름
                alarmVo.setAsuname(suname); // 과목명
                alarmVo.setAdivision(adivision); // 종류
                alarmVo.setSucode(sucode); // 과목 코드
                alarmVo.setSid(sidlist.get(i)); // list 0번째 값부터 list의 크기만큼
                alarmService.ainsertS(alarmVo); // Alarm Table에 insert 해준다.
            }
        }


        int d = Integer.parseInt(rdeadline); // 과제기한 values 값을 int형으로 변환


        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd");
        cal.add(Calendar.DATE, d);
        Date day = new Date(cal.getTimeInMillis());
        boardVo.setTid(tid);
        boardVo.setThcode(thcode);
        boardVo.setBdeadline(day);
        boardVo.setSucode(sucode);

        if(!ofname.equals("")) {
            log.info("#arrin ofname: "+ofname);
            ofname = ofname.trim();
            String url = fileUploadService.saveStore(file, boardVo);
            log.info("#arrin url: "+url);
            log.info("#arrin thcode: "+boardVo.getThcode());
            boardService.insertOkFileS(boardVo);
            return "redirect:mysubject.do?sucode="+sucode+"";
        }
        else {
            boardService.insertNotFileS(boardVo);
            return "redirect:mysubject.do?sucode="+sucode+"";
        }

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
