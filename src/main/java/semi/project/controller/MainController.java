package semi.project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.ClassVo;
import semi.project.domain.StudentVo;
import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;
import semi.project.service.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * 메인화면(==개설한 or 수강중인 클래스 리스트)
 */


@Log4j
@Controller
@RequestMapping("main")
@AllArgsConstructor
public class MainController {

    private SubjectService subjectService;
    private ClassService classService;
    private TeacherService teacherService;
	private StudentService studentService;
    private ThemeService themeService;

    @GetMapping("/list.do")
	public ModelAndView list(HttpSession session) { //메인 화면 subject 리스트 출력

		Object id = session.getAttribute("loginOksid");
		Object id2 = session.getAttribute("loginOkTid");
		String tid = (String)id2;
		String sid = (String)id;
		log.info("#loginOksid: "+sid);

		if(tid != null) {
			List<TeacherVo> tlist = teacherService.tNameCkS(tid);
			List<SubjectVo> list = subjectService.selectBytid(tid);
			log.info("#tlist"+tlist);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index");

			mv.addObject("tSubList",list);
			mv.addObject("tList", tlist);
			return mv;
		}else if(sid !=null) {
			List<StudentVo> slist = studentService.sNameCkS(sid);
			List<String> sucode = classService.selectBySidS(sid);

			ArrayList<SubjectVo> t = new ArrayList<SubjectVo>();

			for(int i = 0;i<sucode.size();i++) {
				List<SubjectVo> list = subjectService.selectAllS(sucode.get(i));
				for(int j=0;j<list.size();j++) {
					t.add(list.get(j));
				}
			}
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index");
			mv.addObject("sSubList",t);
			mv.addObject("sList", slist);
			return mv;
		}
		return null;
	}
	

	@GetMapping("keepOn.do") //수업 보관
	public String keepOn(String sucode) {
		log.info("#keep sucode: "+sucode);
		String skeep = "Y";
		subjectService.updateKeepOnS(skeep, sucode);
		return "redirect:../main/list.do";
	}

	@GetMapping("keepOff.do") //수업 보관 취소
	public String keepOff(String sucode) {
		log.info("#keep sucode: "+sucode);
		String skeep = "N";
		subjectService.updateKeepOffS(skeep, sucode);
		return "redirect:../main/list.do";
	}



//	@GetMapping("keepList.do")
//	public String keepSubject(){
//
//		return "content/keep";
//	}

	@GetMapping("keepList.do") //수업보관함 리스트 불러오기
	public ModelAndView keepList(SubjectVo subjectVo, HttpSession session) {
		Object id = session.getAttribute("loginOksid");
		Object id2 = session.getAttribute("loginOkTid");
		String tid = (String)id2;
		String sid = (String)id;
		log.info("센세id"+tid);
		if(tid != null) {

			List<TeacherVo> tlist = teacherService.tNameCkS(tid);
			List<SubjectVo> list = subjectService.selectBytid(tid);
			log.info("선생님 수업 킵"+tlist);
			log.info("선생님 수업 킵"+list);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("content/keep");
			mv.addObject("tSubList",list);
			mv.addObject("tList", tlist);
			return mv;
		}else if(sid !=null){
			List<StudentVo> slist = studentService.sNameCkS(sid);
			ArrayList<SubjectVo> t= sInfo2Header(sid);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("content/keep");
			mv.addObject("sSubList",t);
			mv.addObject("sList", slist);
			return mv;
		}

		return null;
	}

	ArrayList<SubjectVo> sInfo2Header(String sid){ //header.jsp에 학생 정보를 보내기 위한 메소드입니다

		List<String> sucodelist = classService.selectBySidS(sid);
		ArrayList<SubjectVo> t = new ArrayList<SubjectVo>();
		for(int i = 0;i<sucodelist.size();i++) {
			List<SubjectVo> list = subjectService.selectAllS(sucodelist.get(i));
			for(int j=0;j<list.size();j++) {
				t.add(list.get(j));
			}
		}
		return t;
	}

}
