package semi.project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.ClassVo;
import semi.project.domain.StudentVo;
import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;
import semi.project.service.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


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
    private SubjectService subjectService;
    private ClassService classService;
    private TeacherService teacherService;
	private StudentService studentService;
    private ThemeService themeService;

    @RequestMapping(value = "header.do", method = RequestMethod.GET)
    public ModelAndView header(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("content/header");


        return mv;
    }
}
