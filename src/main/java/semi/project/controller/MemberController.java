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

    @GetMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
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
            msg = teacherService.temailckS(email); //DB에 클라이언트가 입력한 email이 있으면 "yesEmail", 없으면 "noEmail"
        }else if(type.equals("student")){
            msg = studentService.semailckS(email); //DB에 클라이언트가 입력한 email이 있으면 "yesEmail", 없으면 "noEmail"
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
            msg = teacherService.tidckS2(id); //DB에 클라이언트가 입력한 ID가 있으면 "yesId", 없으면 "noId"
        }else if(type.equals("student")){
            msg = studentService.sidckS2(id); //DB에 클라이언트가 입력한 ID가 있으면 "yesId", 없으면 "noId"
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
