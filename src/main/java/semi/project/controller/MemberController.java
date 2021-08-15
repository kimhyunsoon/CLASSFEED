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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j
@Controller
@RequestMapping("member")
@AllArgsConstructor
public class MemberController {
    private TeacherService teacherService;
    private StudentService studentService;
    private SubjectService subjectService;


    @PostMapping("login.do")
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

    @GetMapping("sign_up.do")
    public String login() {
        return "content/sign_up";
    }


    @RequestMapping(value = "checkEmail", method = RequestMethod.POST)
    @ResponseBody
    public String checkEmail(String email){
        log.info("email is"+email);

        String msg = teacherService.temailckS(email);
        log.info("msg: "+msg);
        return msg;
    }

    @RequestMapping(value = "checkId", method = RequestMethod.POST)
    @ResponseBody
    public String checkId(
                @RequestParam("id") String id,
                @RequestParam("type") String type
    ){
        log.info("id is"+id);
        String msg=null;
        if(type.equals("teacher")){
            msg = teacherService.tidckS2(id);
        }else if(type.equals("student")){
            msg = studentService.sidckS2(id);
        }
        return msg;
    }

    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    @ResponseBody
    public String signUp(
            @RequestParam("type") String type,
            @RequestParam("name") String name,
            @RequestParam("agency") String agency,
            @RequestParam("id") String id,
            @RequestParam("email") String email,
            @RequestParam("pwd") String pwd,
            @RequestParam("phone") String phone
    ){
        log.info("name is"+name);
        if(type.equals("teacher")){
            log.info("teacher ok");
        }
        return "OK";
    }



    @PostMapping("sign_up.do")
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
