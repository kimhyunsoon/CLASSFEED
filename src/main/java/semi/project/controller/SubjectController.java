package semi.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import semi.project.domain.ClassVo;
import semi.project.domain.StudentRandom;
import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;
import semi.project.service.ClassService;
import semi.project.service.SubjectService;
import semi.project.service.TeacherService;

/**
 * 선생님 과목 추가(subject.do)
 * 학생이 수업 참여 (class.do)
 * */
@Log4j
@Controller
@RequestMapping("subject")
public class SubjectController {

    private TeacherService teacherService;
    private SubjectService subjectService;
    private ClassService classService;


    public SubjectController(TeacherService teacherService,
                             SubjectService subjectService,
                             ClassService classService){
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.classService = classService;
    }


    @PostMapping("/subject.do")
    public String addSubject(HttpSession session, SubjectVo subjectVo) {
        String tid = (String)session.getAttribute("loginOkTid");
        if(teacherService.validateTeacherExist(tid) == 0){
            return null;
        }
        subjectVo.setTid(tid);
        subjectService.insertSubject(subjectVo);

        return "redirect:../main/list.do";
    }

    @PostMapping("/class.do")
    public String addClass(HttpSession session, ClassVo classVo,
                                @RequestParam("sucode")String sucode) {
        String sid = (String)session.getAttribute("loginOksid");

        if(subjectService.validateSubjectExist(sucode) == 0) {
            System.out.println("잘못된 수업코드 입니다");
            return null;
        }
        classVo.setSucode(sucode);
        classVo.setSid(sid);
        classService.insertClass(classVo);

        return "redirect:../main/list.do";
    }

}












