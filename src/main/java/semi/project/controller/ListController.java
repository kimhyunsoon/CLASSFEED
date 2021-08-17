package semi.project.controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.BoardVo;
import semi.project.domain.NoticeVo;
import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;
import semi.project.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 스트림페이지 리스트 출력
 * 수업페이지 리스트 출력
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

    @GetMapping("/mystream.do") // 해당 과목의 자료, 과제 를 불러 오기 위해
    public ModelAndView mysubject(String sucode, HttpSession session) {
        // jsp에서 sucode를 물고온다.
        Object id1 = session.getAttribute("loginOksid"); // session 에서 sid 값 불러오기
        Object id2 = session.getAttribute("loginOkTid"); // session 에서 tid 값 불러오기

        String sid = (String)id1; // DB에 넣어야 하니깐 String으로 형변환
        String tid = (String)id2;



        if(tid!=null) { // tid가 null이 아니라는건 session에 tid 값이 존재(= 선생님이 로그인중)
            log.info("#check sucode: "+sucode);
            List<SubjectVo> subList = subjectService.selectAllS(sucode);
            List<BoardVo> boardList = boardService.selectBySucode(sucode);
            List<NoticeVo> noticeList = noticeService.selectBySucode(sucode);
            log.info("#sublist: "+subList);
            log.info("#boardList: "+boardList);

            session.setAttribute("sucode", sucode); // key=sucode, value=sucode 세션에 셋팅
            ModelAndView mv = new ModelAndView();
            mv.setViewName("content/stream");
            mv.addObject("tLogin",tid);
            mv.addObject("subList",subList);
            mv.addObject("boardList", boardList);
            mv.addObject("noticeList", noticeList);

            // 선생 과 학생을 구분 해야 하므로 key=tsucode 로 설정
            return mv;
        }else if(sid!=null) {

            List<SubjectVo> subList = subjectService.selectAllS(sucode);
            List<BoardVo> boardList = boardService.selectBySucode(sucode);
            List<NoticeVo> noticeList = noticeService.selectBySucode(sucode);

            log.info("#sublist: "+subList);
            log.info("#boardList: "+boardList);
            log.info("#noticeList: "+noticeList);
            session.setAttribute("sucode", sucode);

            ModelAndView mv = new ModelAndView();
            mv.setViewName("content/stream");
            mv.addObject("sLogin",sid);
            mv.addObject("subList",subList);
            mv.addObject("boardList", boardList);
            mv.addObject("noticeList", noticeList);


            // 학생 과 선생을 구분 해야 하므로 key=ssucode 로 설정
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

}
