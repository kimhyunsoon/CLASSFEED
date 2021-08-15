package semi.project.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import semi.project.domain.BoardVo;
import semi.project.domain.ClassVo;
import semi.project.domain.StudentRandom;
import semi.project.domain.StudentVo;
import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;
import semi.project.domain.ThemeVo;
import semi.project.service.ClassService;
import semi.project.service.StudentService;
import semi.project.service.SubjectService;
import semi.project.service.TeacherService;
import semi.project.service.ThemeService;

@Log4j
@Controller
@RequestMapping("/test/*")
public class TestController {
	@Autowired
	TeacherService teacherService;
	@Autowired
	StudentService studentService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	ClassService classService;
	@Autowired
	ThemeService themeService;
	
	
	@GetMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/test.do")
	public String test() {
		return "test/test";
	}
	
	@GetMapping("/login.do")
	public String login() {
		return "test/login";
	}
	
	@GetMapping("/list.do")
	public ModelAndView list(ClassVo classVo, SubjectVo subjectVo, HttpSession session) {
		
		
		
		Object id = session.getAttribute("sid");
		Object id2 = session.getAttribute("tid");
		String tid = (String)id2;
		String sid = (String)id;
		
		System.out.println("#tid: "+tid);
		System.out.println("#sid: "+sid);
		if(tid != null) {
			List<SubjectVo> list = subjectService.selectBytid(tid);
			System.out.println(list);
			ModelAndView mv = new ModelAndView("test/list","tlist",list);
			return mv;
		}else if(sid !=null) {
			List<String> sucode = classService.selectBySidS(sid);
			ArrayList<SubjectVo> t = new ArrayList<SubjectVo>();
			
			for(int i = 0;i<sucode.size();i++) {
				List<SubjectVo> list = subjectService.selectAllS(sucode.get(i));
				for(int j=0;j<list.size();j++) {
					System.out.println("#list["+i+"]: "+list.get(j));
					t.add(list.get(j));
				}
			}
			ModelAndView mv = new ModelAndView("test/list","slist",t);
			return mv;
		}
		
		return null;
		/*
		List<String> sucode = classService.selectBySidS(sid);
		ArrayList<SubjectVo> t = new ArrayList<SubjectVo>();
		
		for(int i = 0;i<sucode.size();i++) {
			List<SubjectVo> list = subjectService.selectAllS(sucode.get(i));
			for(int j=0;j<list.size();j++) {
				System.out.println("#list["+i+"]: "+list.get(j));
				t.add(list.get(j));
			}
		}
		ModelAndView mv = new ModelAndView("test/list","list",t);
		return mv;*/
	}

	@GetMapping("/mysubject.do")
	public ModelAndView mysubject(String sucode, HttpSession session) {
		Object id = session.getAttribute("sid");
		Object id2 = session.getAttribute("tid");
		String tid = (String)id2;
		String sid = (String)id;
		if(tid!=null) {
			session.setAttribute("sucode", sucode);
			System.out.print("##sucode: "+sucode+", tid: "+tid);
			ModelAndView mv = new ModelAndView("test/mysubject","tsucode",sucode);
			return mv;
		}else if(sid!=null) {
			session.setAttribute("sucode", sucode);
			System.out.println("##sucode: "+sucode);
			ModelAndView mv = new ModelAndView("test/mysubject","ssucode",sucode);
			return mv;
		}
		return null;
	}
	
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
	/**/
	@PostMapping("/subject.do")
	public ModelAndView board(HttpSession session, SubjectVo subjectVo) {
		StudentRandom r = new StudentRandom();
		char[] num = r.ran();
		String fail = "";
		Object s = session.getAttribute("tid");
		String tid = (String)s;
		String sucode="";
		
		
		System.out.println(sucode.length());
		if(num == null) {
			System.out.println("잠시후 다시시도...");
			ModelAndView modelAndView = new ModelAndView("test/main","fail",fail);
			return modelAndView;
		}else {
			for(int i =0;i<num.length;i++) {
				sucode += Character.toString(num[i]);
			}
			sucode = sucode.trim();
			subjectVo.setTid(tid);
			subjectVo.setSucode(sucode);
			subjectService.suinsertS(subjectVo);
			ModelAndView modelAndView = new ModelAndView("test/login");
			return modelAndView;
		}
	}
	
	@PostMapping("/class.do")
	public ModelAndView subjectClass(HttpSession session, ClassVo classVo) {
		Object id = session.getAttribute("sid");
		String sid = (String)id;
		String code = classVo.getSucode();
		System.out.println("id:"+sid+", code:"+code);
		String re = subjectService.selectBySucodeS(code);
		System.out.println(re);
		if(re==null) {
			System.out.println("잘못된 수업코드 입니다");
			return null;
		}else {
			List<SubjectVo> list = subjectService.selectAllS(code);
			classVo.setSucode(code);
			classVo.setSid(sid);
			
			classService.insertS(classVo);
			ModelAndView mv = new ModelAndView("test/list","list",list);
			return mv;
		}
	}
	
	@PostMapping("/theme.do") // 현수형
	public ModelAndView Theme(HttpSession session, ThemeVo themeVo) {
		StudentRandom r = new StudentRandom();
		char[] num = r.ran();
		String fail = "";
		Object t = session.getAttribute("tid");
		String tid = (String)t;
		
		Object s = session.getAttribute("sucode");
		String sucode = (String)s;
		sucode = sucode.trim();
		String thcode="";
		
		thcode = thcode.trim();
		if(num == null) {
			System.out.println("잠시후 다시시도...");
			ModelAndView modelAndView = new ModelAndView("test/main","fail",fail);
			return modelAndView;
		}else {
			for(int i =0;i<num.length;i++) {
				thcode += Character.toString(num[i]);
			}
			String thcodes = thcode.trim();
			themeVo.setThcode(thcodes);
			themeVo.setTid(tid);
			themeVo.setSucode(sucode);
			themeService.thinsertS(themeVo);
			List<ThemeVo> thinformation = themeService.selectAllS(thcodes);
			ModelAndView modelAndView = new ModelAndView("test/succ","thinformation", thinformation);
			return modelAndView;
		}
	}
	
	@GetMapping("/themelist.do")
	public ModelAndView themeList(HttpSession session) {
		Object s = session.getAttribute("sucode");
		String sucode = (String)s;
		System.out.println("#124125125:"+sucode);
		List<ThemeVo> list = themeService.selectBysucodeS(sucode);
		ModelAndView mv = new ModelAndView("test/mytheme","list",list);
		return mv;
	}
}















