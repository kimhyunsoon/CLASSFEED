package semi.project.controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import semi.project.domain.StudentVo;
import semi.project.domain.TeacherVo;
import semi.project.service.StudentService;
import semi.project.service.SubjectService;
import semi.project.service.TeacherService;

@Log4j
@Controller
@RequestMapping("/member/*")
@AllArgsConstructor
public class MemberController {
    TeacherService teacherService;
    StudentService studentService;
    SubjectService subjectService;

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
