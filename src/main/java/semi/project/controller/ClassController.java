package semi.project.controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.BoardVo;
import semi.project.domain.ThemeVo;
import semi.project.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * '수업'카테고리 누르면 나오는 화면의 리스트들을 출력
 * 주제리스트, 각각의 주제에 포함된 자료와 과제 리스트 등
 * */

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/class/*")
public class ClassController {

    SubjectService subjectService;
    ClassService classService;
    AlarmService alarmService;
    BoardService boardService;
    ThemeService themeService;


    @GetMapping("clist.do") // !!! 수업 탭의 리스트 출력(왼쪽 주제리스트, 중앙에 주제 안에 과제,자료)
    public ModelAndView classlist(HttpSession session) {
        Object id1 = session.getAttribute("sid");
        Object id2 = session.getAttribute("tid");
        Object code = session.getAttribute("sucode");
        String sid = (String)id1; String tid=(String)id2;
        String sucode = (String)code;
        if(tid!=null) {
            return null;
        }else {

            log.info("#classlist sucode: "+sucode);
            List<BoardVo> blist = boardService.boardSelectClassS(sucode);
            List<ThemeVo> tlist = themeService.selectAllClassS(sucode);


            ModelAndView mv = new ModelAndView();
            mv.setViewName("test/classList");
            mv.addObject("blist",blist);
            mv.addObject("tlist",tlist);
            return mv;
        }

    }

}
