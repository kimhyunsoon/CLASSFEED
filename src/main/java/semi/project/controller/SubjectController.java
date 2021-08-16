package semi.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 과목의 리스트 출력(mysubject.do) 및 과목 추가(subject.do)
 * 학생이 수업 참여 (class.do)
 * */
@Log4j
@Controller
@RequestMapping("subject")
@AllArgsConstructor
public class SubjectController {

    TeacherService teacherService;
    SubjectService subjectService;
    ClassService classService;

    @PostMapping("/subject.do") // 과목 추가
    public ModelAndView addSubject(HttpSession session, SubjectVo subjectVo) {
        // jsp 에서 suname, ssubname 값 을 가져온다.

        StudentRandom random = new StudentRandom();
        char[] num = random.ran(); // 랜덤 과목코드 생성

        String fail = "fail";
        String sucode=""; // 과목 코드를 담을 변수
        Object id = session.getAttribute("tid"); // 과목 추가는 선생님만 가능 하므로 session 에서 tid 값 불러온다
        log.info("#Subject id"+id);
        String tid = (String)id; // Object -> String 형변환
        log.info("#Subject tid"+tid);

        TeacherVo tinfo = teacherService.tlnfoS(tid);

        if(num == null) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("test/main");
            mv.addObject("fail",fail);
            mv.addObject("tinfo",tinfo);
            return mv;
        }else {
            log.info("#num"+num);
            for(int i =0;i<num.length;i++) {
                sucode += Character.toString(num[i]);
            }
            sucode = sucode.trim(); // 공백 제거
            log.info("#sucode"+sucode);
            subjectVo.setTid(tid); // tid 값 셋팅
            subjectVo.setSucode(sucode); // sucode 값 셋팅
            subjectService.suinsertS(subjectVo); // 과목  insert
            ModelAndView mv = new ModelAndView("content/classList","tinfo",tinfo);
            return mv;
        }
    }

    @PostMapping("/class.do")
    public ModelAndView classIn(HttpSession session, ClassVo classVo,
                                @RequestParam("sucode")String sucode) {
        Object id = session.getAttribute("sid"); // 수업 참여는 학생만 하므로 sid값 만 존재
        String sid = (String)id;
        String re = subjectService.selectBySucodeS(sucode); // Subject Table에 입력한 수업 코드 가 있는지 확인하기위해
        if(re==null) {
            System.out.println("잘못된 수업코드 입니다"); // 추후에 수업코드가 없다고 메세지 표출 해야함
            return null;
        }else {
            List<SubjectVo> list = subjectService.selectAllS(sucode);
            classVo.setSucode(sucode);
            classVo.setSid(sid);

            classService.insertS(classVo);

            List<String> sucode2 = classService.selectBySidS(sid);
            ArrayList<SubjectVo> t = new ArrayList<SubjectVo>();
            for(int i = 0;i<sucode2.size();i++) {
                List<SubjectVo> list2 = subjectService.selectAllS(sucode2.get(i));
                for(int j=0;j<list.size();j++) {
                    System.out.println("#list["+i+"]: "+list.get(j));
                    t.add(list.get(j));
                }
            }
            ModelAndView mv = new ModelAndView("test/list","slist",t);
            return mv;
        }
    }
    // 추후에 과목코드의 중복을 확인해서 insert 할 예정!
}












