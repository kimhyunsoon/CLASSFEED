package semi.project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.ClassVo;
import semi.project.domain.SubjectVo;
import semi.project.service.ClassService;
import semi.project.service.SubjectService;
import semi.project.service.TeacherService;
import semi.project.service.ThemeService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Log4j
@Controller
@RequestMapping("main")
@AllArgsConstructor
public class ListController {

    private SubjectService subjectService;
    private ClassService classService;
    private TeacherService teacherService;
    private ThemeService themeService;

    @GetMapping("/list.do")
	public ModelAndView list(ClassVo classVo, SubjectVo subjectVo, HttpSession session) {



		Object id = session.getAttribute("loginOksid");
		Object id2 = session.getAttribute("loginOkTid");
		String tid = (String)id2;
		String sid = (String)id;

		System.out.println("#listtid: "+tid);
		String tname = teacherService.tNameCkS(tid);
		System.out.println("#listsid: "+sid);
		if(tid != null) {
			List<SubjectVo> list = subjectService.selectBytid(tid);
			System.out.println("#list"+list);
			ModelAndView mv = new ModelAndView();
			//ModelAndView mv = new ModelAndView("content/classList","tlist",list);
			mv.setViewName("content/classList");
			mv.addObject("tlist",list);
			mv.addObject("tName", tname);
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
			ModelAndView mv = new ModelAndView("content/classList","slist",t);
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
}
