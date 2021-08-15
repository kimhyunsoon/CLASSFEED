//package semi.project.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import lombok.extern.log4j.Log4j;
//import semi.project.domain.StudentVo;
//import semi.project.domain.TeacherVo;
//import semi.project.service.ClassService;
//import semi.project.service.StudentService;
//import semi.project.service.SubjectService;
//import semi.project.service.TeacherService;
//import semi.project.service.ThemeService;
//
//@Log4j
//@Controller
//@RequestMapping("class")
//public class ClassController {
//    @Autowired
//    TeacherService teacherService;
//    @Autowired
//    StudentService studentService;
//    @Autowired
//    SubjectService subjectService;
//    @Autowired
//    ClassService classService;
//    @Autowired
//    ThemeService themeService;
//
//    @PostMapping("/list.do")
//    public ModelAndView logins(String id, String pwd, HttpSession session) {
//        TeacherVo tinformation = teacherService.tloginS(id, pwd);
//        StudentVo sinformation = studentService.sloginS(id, pwd);
//
//        if (tinformation != null) { // 선생 정보 있음
//            System.out.println("tinformation:"+tinformation);
//            ModelAndView modelAndView = new ModelAndView("content/classList","tinformation",tinformation);
//            //session.invalidate();
//            session.setAttribute("tid", id);
//            return modelAndView;
//        }else if(sinformation != null) { // 학생 정보 잇음
//            ModelAndView modelAndView = new ModelAndView("content/classList","sinformation",sinformation);
//            //session.invalidate();
//            session.setAttribute("sid", id);
//            return modelAndView;
//        }else {
//            System.out.println("둘다 없음");
//            ModelAndView modelAndView = new ModelAndView("/");
//            return modelAndView;
//        }
//    }
//}
