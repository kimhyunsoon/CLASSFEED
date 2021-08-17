package semi.project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import semi.project.domain.BoardVo;
import semi.project.domain.ThemeVo;
import semi.project.service.BoardService;
import semi.project.service.ThemeService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

/**
 * 자료 및 과제의 추가
 * */
@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("class")

public class BoardController {

    BoardService boardService;
    ThemeService themeService;

    @PostMapping("/assignment.do")
    public String assignIn(ThemeVo themeVo, @RequestParam("themelist")String thcode,
                           HttpSession session, @RequestParam("rdeadline")String rdeadline, BoardVo boardVo) {
        int d = Integer.parseInt(rdeadline); // 과제기한 values 값을 int형으로 변환

        Object id = session.getAttribute("tid");
        String tid = (String)id;

        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd");
        cal.add(Calendar.DATE, d);
        Date day = new Date(cal.getTimeInMillis());
        boardVo.setTid(tid);
        boardVo.setThcode(thcode);
        boardVo.setBdeadline(day);

        boardService.insertNotFileS(boardVo);
        Object code = session.getAttribute("sucode");
        String sucode = (String)code;
        return "redirect:myclass.do?sucode="+sucode+"";
    }



}
