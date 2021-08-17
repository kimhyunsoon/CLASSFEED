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


/**
 * 회원가입 & 로그인 컨트롤러
 * */
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
        String msg = null;

        //선생님 검사
        msg = teacherService.tloginS(id, pwd);
        if(msg.equals("success")){
            String tid = teacherService.tidckS(id);
            session.setAttribute("loginOkTid", tid);
            ModelAndView modelAndView = new ModelAndView("content/loginFilter", "msg", msg);
            return modelAndView;
        }else{
            msg = studentService.sloginS(id, pwd);
            if(msg.equals("success")){
                String sid = studentService.sidckS(id);
                session.setAttribute("loginOksid", sid);
                ModelAndView modelAndView = new ModelAndView("content/loginFilter", "msg", msg);
                return modelAndView;
            }else{
                ModelAndView modelAndView = new ModelAndView("content/loginFilter", "msg", msg);
                return modelAndView;
            }
        }
    }

    @GetMapping("sign_up.do")
    public String login() {
        return "content/sign_up";
    }


    @RequestMapping(value = "checkEmail", method = RequestMethod.POST)
    @ResponseBody
    public String checkEmail(
            @RequestParam("email") String email,
            @RequestParam("type") String type){
        log.info("email is"+email);
        String msg = null;
        if(type.equals("teacher")){
            msg = teacherService.temailckS(email);
        }else if(type.equals("student")){
            msg = studentService.semailckS(email);
        }
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
            TeacherVo teacherVo = new TeacherVo(id, pwd, name, phone, email, agency, null);
            teacherService.tinsertS(teacherVo);

        }else if(type.equals("student")){
            StudentVo studentVo = new StudentVo(id,name,phone,pwd,email,0,null);
            studentService.sinsertS(studentVo);
        }
        return "OK";
    }
}
