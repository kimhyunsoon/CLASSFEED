package semi.project.controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.StudentVo;
import semi.project.domain.TeacherVo;
import semi.project.service.StudentService;
import semi.project.service.SubjectService;
import semi.project.service.TeacherService;

import javax.servlet.http.HttpSession;

@Log4j
@Controller
@RequestMapping("/member/*")
@AllArgsConstructor
public class MemberController {
    TeacherService teacherService;
    StudentService studentService;
    SubjectService subjectService;


    @PostMapping("/login.do")
    public ModelAndView logins(String id, String pwd, HttpSession session) {
        TeacherVo tinformation = teacherService.tloginS(id, pwd);
        StudentVo sinformation = studentService.sloginS(id, pwd);

        if (tinformation != null) { // 선생 정보 있음
            System.out.println("tinformation:"+tinformation);
            ModelAndView modelAndView = new ModelAndView("test/main","tinformation",tinformation);
            //session.invalidate();
            session.setAttribute("tid", id);
            return modelAndView;
        }else if(sinformation != null) { // 학생 정보 잇음
            ModelAndView modelAndView = new ModelAndView("test/main","sinformation",sinformation);
            //session.invalidate();
            session.setAttribute("sid", id);
            return modelAndView;
        }else {
            System.out.println("둘다 없음");
            ModelAndView modelAndView = new ModelAndView("/");
            return modelAndView;
        }
    }

    @GetMapping("/sign_up.do")
    public String login() {
        return "content/sign_up";
    }

    @ResponseBody
    @PostMapping(value = "chartData", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String checkEmail(String email){
        String msg = teacherService.temailckS(email);
        log.info(msg);
        if(msg.equals("noEmail")){
            return msg;
        }
        return null;
    }


    @PostMapping("/sign_up.do")
    public String sign_up(StudentVo studentVo, TeacherVo teacherVo, @RequestParam("jobck") String job) {
        System.out.println("ㅎㅇ "+job);
        if(job.equals("teacher")) {
            teacherService.tinsertS(teacherVo);
            return "redirect:/";
        }else if(job.equals("student")) {
            studentService.sinsertS(studentVo);
            return "redirect:/";
        }
        return "redirect:/";
    }



}
