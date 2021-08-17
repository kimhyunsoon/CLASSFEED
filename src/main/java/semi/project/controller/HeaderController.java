package semi.project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 상단 정보, 사이드메뉴 컨트롤
 * XXX.do 접속
 * -> XXX.do 컨트롤러로감
 * -> XXX.jsp 를 보여주려는데
 * -> XXX.jsp 상단에 header.jsp 있음
 * -> header.jsp 접속
 * -> header.do 컨트롤러로감
 * -> 다 조합해서 보여줌
 */

@Log4j
@Controller

public class HeaderController {

    @RequestMapping(value = "header.do", method = RequestMethod.GET)
    public ModelAndView header(HttpSession session){
        Object teacher = session.getAttribute("loginOkTid");
        String tid = (String) teacher;
        Object student = session.getAttribute("loginOksid");
        String sid = (String) student;
        log.info("login ok teacher"+tid);
        log.info("login ok student"+sid);
        if(tid !=null){
            ModelAndView mv = new ModelAndView("header","sessionT",tid);
            return mv;
        }else if(sid !=null){
            ModelAndView mv = new ModelAndView("header","sessionS",sid);
            return mv;

        }
        return null;
    }
}
