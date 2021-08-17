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
 * 공통모듈인 헤더입니다.
 * main, stream, class탭에서 뿌려주는 정보를 가지고 사이드바 메뉴를 구현합니다
 * 로그아웃을 구현합니다
 * 알림도 이쪽에서 구현할 예정입니다
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
