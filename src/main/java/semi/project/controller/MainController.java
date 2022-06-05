package semi.project.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.AlarmVo;
import semi.project.domain.StudentVo;
import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;
import semi.project.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 메인화면(==개설한 or 수강중인 클래스 리스트)
 * 수업 보관 및 복원, 보관함 리스트 출력
 */


@Log4j
@Controller
@RequestMapping("main")
public class MainController {

    private SubjectService subjectService;
    private ClassService classService;
    private TeacherService teacherService;
	private StudentService studentService;
    private AlarmService alarmService;

    private static final String Y = "Y";
	private static final String N = "N";

    public MainController(
			SubjectService subjectService,
			ClassService classService,
			TeacherService teacherService,
			StudentService studentService,
			AlarmService alarmService
	){
    	this.subjectService = subjectService;
    	this.classService = classService;
    	this.teacherService = teacherService;
    	this.studentService = studentService;
    	this.alarmService = alarmService;
	}


    //메인리스트 출력
    @GetMapping("/list.do")
	public String mainList(HttpSession session, Model model) throws Exception {

		String tid = (String)session.getAttribute("loginOkTid");
		String sid = (String)session.getAttribute("loginOksid");

		if(tid == null && sid == null) return "redirect:/";

		if(tid != null) {
			this.setTeacherDefaultInfo(tid, model); 			//선생님일때
		}else {
			this.setStudentDefaultInfo(sid, model); 			//학생일때
		}
		return "index";
	}



	@GetMapping("keepList.do") //수업보관함 리스트 불러오기
	public String keepList(SubjectVo subjectVo, HttpSession session, Model model) {
		String tid = (String)session.getAttribute("loginOkTid");
		String sid = (String)session.getAttribute("loginOksid");

		if(tid == null && sid == null) return "redirect:/";

		if(tid != null) {
			this.setTeacherDefaultInfo(tid, model);			//선생님일때
		}else {
			this.setStudentDefaultInfo(sid, model);			//학생일때
		}
		return "content/keep";
	}

	@GetMapping("keepOn.do") //수업 보관
	public String keepOnSubject(String sucode) {
		subjectService.updateSubjectKeepOn(Y, sucode);
		return "redirect:../main/list.do";
	}

	@GetMapping("keepOff.do") //수업 보관 취소
	public String keepOffSubject(String sucode) {
		subjectService.updateSubjectKeepOff(N, sucode);
		return "redirect:../main/list.do";
	}





	@GetMapping("/alarm.do")
	public ModelAndView mainAlarm(HttpSession session) {
		Object id = session.getAttribute("sid");
		String sid = (String)id;

		List<AlarmVo> alarmList =  alarmService.aselectBysidS(sid);
		ModelAndView mv = new ModelAndView("index","alarmList",alarmList);

		return mv;
	}


	private void setTeacherDefaultInfo(String tid, Model model){
		List<TeacherVo> tList= teacherService.selectTeacherListByTid(tid);
		List<SubjectVo> tSubList = subjectService.selectSubjectByTid(tid);
		model.addAttribute("tSubList",tSubList);
		model.addAttribute("tList", tList);
	}

	private void setStudentDefaultInfo(String sid, Model model){
		List<StudentVo> sList = studentService.selectStudentBySid(sid);
		List<String> sucodeList = classService.selectSucodeBySid(sid);
		List<SubjectVo> sSubList = subjectService.selectAttendedSubject(sucodeList);
		model.addAttribute("sSubList",sSubList);
		model.addAttribute("sList", sList);
	}



}
