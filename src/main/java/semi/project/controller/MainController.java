package semi.project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.*;
import semi.project.service.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    private ThemeService themeService;
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

	private Map<String,Object> getTeacherDefaultInfo(String tid){
    	Map<String, Object> infoMap = new HashMap<>();
		infoMap.put("tList",teacherService.selectTeacherByTid(tid));
		infoMap.put("tSubject",subjectService.selectSubjectByTid(tid));
    	return infoMap;
	}

	private Map<String,Object> getStudentDefaultInfo(String sid){
		Map<String, Object> infoMap = new HashMap<>();
		List<String> sucodeList = classService.selectSucodeBySid(sid);

		infoMap.put("sList",studentService.selectStudentBySid(sid));
		infoMap.put("sSubList",subjectService.selectAttendedSubject(sucodeList));
		return infoMap;
	}



    //메인리스트 출력
    @GetMapping("/list.do")
	public String mainList(HttpSession session, Model model) throws Exception {

		String tid = (String)session.getAttribute("loginOkTid");
		String sid = (String)session.getAttribute("loginOksid");

		if(tid == null && sid == null) return "redirect:/";

		if(tid != null) {
			//선생님일때
			Map<String, Object> teacherInfo= this.getTeacherDefaultInfo(tid);
			model.addAttribute("tSubList",teacherInfo.get("tSubject"));
			model.addAttribute("tList", teacherInfo.get("tList"));

		}else {
			//학생일때
			Map<String, Object> studentInfo= this.getStudentDefaultInfo(sid);
			model.addAttribute("sSubList",studentInfo.get("sSubList"));
			model.addAttribute("sList", studentInfo.get("sList"));
		}
		return "index";
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





	@GetMapping("keepList.do") //수업보관함 리스트 불러오기
	public String keepList(SubjectVo subjectVo, HttpSession session, Model model) {
		String tid = (String)session.getAttribute("loginOkTid");
		String sid = (String)session.getAttribute("loginOksid");

		if(tid == null && sid == null) return "redirect:/";

		if(tid != null) {
			//선생님일때
			Map<String, Object> teacherInfo= this.getTeacherDefaultInfo(tid);
			model.addAttribute("tSubList",teacherInfo.get("tSubject"));
			model.addAttribute("tList", teacherInfo.get("tList"));

		}else {
			//학생일때
			Map<String, Object> studentInfo= this.getStudentDefaultInfo(sid);
			model.addAttribute("sSubList",studentInfo.get("sSubList"));
			model.addAttribute("sList", studentInfo.get("sList"));
		}
		return "content/keep";
	}



	@GetMapping("/alarm.do")
	public ModelAndView mainAlarm(HttpSession session) {
		Object id = session.getAttribute("sid");
		String sid = (String)id;

		List<AlarmVo> alarmList =  alarmService.aselectBysidS(sid);

		System.out.println(alarmList);

		ModelAndView mv = new ModelAndView("index","alarmList",alarmList);

		return mv;
	}


}
