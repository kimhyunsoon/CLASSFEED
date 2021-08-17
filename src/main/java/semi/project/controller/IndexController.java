package semi.project.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

/**
 * 사용자 session 정보가 있으면 메인 화면으로, 없으면 login.jsp 연결
 */

@Log4j
@Controller
public class IndexController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpSession session) {
		Object teacher = session.getAttribute("loginOkTid");
		String tid = (String) teacher;
		Object student = session.getAttribute("loginOksid");
		String sid = (String) student;
		log.info("login ok teacher"+tid);
		log.info("login ok student"+sid);
		if(tid ==null && sid ==null){
			return "content/login";
		}
		return "index";
	}
	
}
