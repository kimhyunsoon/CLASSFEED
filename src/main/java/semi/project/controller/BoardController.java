package semi.project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.*;
import semi.project.filesetting.Path;
import semi.project.service.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 과제or자료 상세내용 페이지 출력
 * 학생일 경우 과제 제출 기능
 * 선생님일 경우 board 테이블에 과제, 자료 생성
 * 파일 다운로드 기능
 * */

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("myboard")

public class BoardController {
    private TeacherService teacherService;
    private SubjectService subjectService;
    private ClassService classService;
    private BoardService boardService;
    private NoticeService noticeService;
    private StudentService studentService;
    private ThemeService themeService;
    private AlarmService alarmService;
    private FileUploadService fileUploadService;
    private AfileService afileService;



    // 수업 탭에서 과제or자료를 눌렀을때
    @GetMapping("/content.do")
    public ModelAndView readBoard(String sucode, HttpSession session,long bseq, BoardVo boardVo, AfileVo afileVo) {
        Object id1 = session.getAttribute("loginOksid"); // session 에서 sid 값 불러오기
        Object id2 = session.getAttribute("loginOkTid"); // session 에서 tid 값 불러오기
        Object code = session.getAttribute("sucode");
        String sid = (String)id1;
        String tid = (String)id2;
        String gaincode = (String)code;
        log.info("세션에서 받아온: "+gaincode);
        log.info("#boadlist sid:"+sid+" seq: "+bseq);
        log.info("#boadlist tid:"+tid+" seq: "+bseq);
        List<SubjectVo> subList = subjectService.selectAllS(gaincode); //수업코드로 subject 테이블 불러오기


        
        if(tid != null){
            String tname = teacherService.tnameS(tid);
            List<SubjectVo> list = subjectService.selectBytid(tid);
            List<TeacherVo> tlist = teacherService.tNameCkS(tid);
            List<BoardVo> blist =  boardService.boardSelectBySeqS(bseq);
            List<AfileVo> submitList = afileService.afileSelectBySeqS(bseq); //제출한 학생 리스트
            log.info("#submission list"+submitList);
            log.info("bseq를 사용해서불러온 보드리스트"+blist);
            log.info("선생님아이디"+tid);
            log.info("수업코드로 받아온 서브젝트 정보"+subList);
            log.info("센세 아이디로 받아온 서브젝트 정보"+list);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("content/board");
            mv.addObject("tLogin",tid);
            mv.addObject("tname",tname);
            mv.addObject("list", blist);
            mv.addObject("submit", submitList);
            mv.addObject("subList",subList); //header.jsp
            mv.addObject("tSubList", list); //header.jsp
            mv.addObject("tList", tlist); //header.jsp
            return mv;

        }else if(sid !=null){
            String writeTid = boardService.boardSelectTidS(bseq); // bseq를 이용해 선생님 아이디 불러옴
            log.info("writeTid"+writeTid);
            String tname = teacherService.tnameS(writeTid); // 불러온 tid를 이용해서 선생님 이름 불러옴
            List<BoardVo> list =  boardService.boardSelectBySeqS(bseq);
            log.info("bseq를 사용해서불러온"+list);
            log.info("#sid: "+sid);
            afileVo.setSid(sid);
            afileVo.setBseq(bseq);
            List<AfileVo> submitList = afileService.afileSelectBySids(afileVo);
            log.info("submitList: "+submitList);



            List<StudentVo> slist = studentService.sNameCkS(sid);
            log.info("slist: "+slist);
            ArrayList<SubjectVo> t= sInfo2Header(sid);

            ModelAndView mv = new ModelAndView();
            mv.setViewName("content/board");
            mv.addObject("list", list); //보드 테이블 정보 보냄
            mv.addObject("tname",tname);
            mv.addObject("submit",submitList);
            mv.addObject("subList",subList); //class.jsp, header.jsp에서
            mv.addObject("sSubList",t); //header.jsp에서
            mv.addObject("sList", slist); //header.jsp에서

            return mv;

        }

        return null;
    }

    @PostMapping("update.do")
    public String boardUpdate(BoardVo boardVo, long bseq) {
//        boardVo.setBseq(bseq);

        log.info("#update.do bitile:"+boardVo.getBtitle());
        log.info("#update.do bcontent:"+boardVo.getBcontent());
        log.info("#update.do bseq:"+boardVo.getBseq());

        boardService.boardUpdateS(boardVo);
        return "redirect:boardlist.do";
    }



    @GetMapping("boardDel.do")
    public String boardDel(long bseq) {
        log.info("#boardDel bseq: "+bseq);
        boardService.deleteBySeqS(bseq);
        return "redirect:../list/myclass.do";
    }




    //선생님이 '자료' 보드에 올린 파일 다운로드
    @GetMapping("download.do")
    public ModelAndView download(String bfname){
        //넘어오는 파일이름으로 파일 객체를 생성해야함
        //페이지를 보고 있는 순간에 파일이 삭제되었지만 새로고침이 되지 않은 경우, 파일이 존재하지 않으므로, 파일 존재여부를 체크해야함
        log.info("넘겨준 파일 이름"+bfname);
        File file = new File(Path.FILE_STORE, bfname);
        log.info("다운로드를 위해 생성된 객체"+file);
        if(file.exists()){
            return new ModelAndView("fileDownloadView", "downloadFile", file); //fileDownloadView: 스프링컨테이너에서 생성된 파일 객체
        }else{
            return new ModelAndView("redirect:content.do");
        }

    }





    //학생이 '과제' 보드에 올린 파일 다운로드
    @GetMapping("adownload.do")
    public ModelAndView aDownload(String afname){
        //넘어오는 파일이름으로 파일 객체를 생성해야함
        //페이지를 보고 있는 순간에 파일이 삭제되었지만 새로고침이 되지 않은 경우, 파일이 존재하지 않으므로, 파일 존재여부를 체크해야함
        log.info("넘겨준 파일 이름"+afname);
        File file = new File(Path.FILE_STORE, afname);
        log.info("다운로드를 위해 생성된 객체"+file);
        if(file.exists()){
            return new ModelAndView("fileDownloadView", "downloadFile", file); //fileDownloadView: 스프링컨테이너에서 생성된 파일 객체
        }else{
            return new ModelAndView("redirect:content.do");
        }

    }

    //학생이 '과제' 보드에 올린 파일 삭제(학생 본인, 선생님??)
    @GetMapping("afileDel.do")
    public String del(@RequestParam String afname, @RequestParam long bseq){
        File file = new File(Path.FILE_STORE, afname); //(부모, 자식), 삭제하려는 대상 파일
        if(file.exists()){
            file.delete();

        }
        afileService.deleteByAfName(afname);
        return "redirect:content.do?bseq="+bseq;
    }



    //학생 과제 제출(afile 테이블, 파일 첨부)
    @PostMapping("sfileUpload.do")
    public String sFileUpload(MultipartFile file, HttpSession session,
                              long bseq, AfileVo afileVo) {
        log.info("?????안와???");

        Object code = session.getAttribute("sucode");
        String sucode = (String)code;
        Object id = session.getAttribute("loginOksid");
        String sid = (String)id;

        String ofname = file.getOriginalFilename(); // 파일 이름을 가져온다
        log.info("ofname"+ofname);

        String sname = studentService.selectBySidS(sid);

        String submission = "submission";
        log.info("#sfileUpload ofname:"+ofname+", sid: "+sid+", bseq: "+bseq+ ",sname: "+sname);

        if(!ofname.equals("")) { // 파일이 존재하면!
            afileVo.setBseq(bseq);
            afileVo.setSid(sid);
            afileVo.setSname(sname);


            ofname = ofname.trim(); // 공백제거해주고
            String url = fileUploadService.sSaveStore(file, afileVo);
            log.info("#url: "+url);
            afileService.fileUploadS(afileVo);
            return "redirect:content.do?bseq="+bseq;
        }else {

            return null;
        }
    }
    

    //기한이 없는(==수업자료) 행 인서트(선생님, board 테이블)
    @PostMapping("/boardin.do")
    public String addBoard(ThemeVo themeVo, @RequestParam("themelist")String thcode,
                          HttpSession session, BoardVo boardVo, AlarmVo alarmVo, MultipartFile file) { //deadline이 없는 수업 자료 insert

        Object code = session.getAttribute("sucode");
        Object id = session.getAttribute("loginOkTid");
        String sucode = (String)code;
        String tid = (String)id;


        String ofname = file.getOriginalFilename();


        String suname = subjectService.selectSunameS(sucode); // 해당하는 과목코드를 이용해 과목 이름을 뽑아온다.
        String tname = teacherService.tnameS(tid); // session을 이용해서  과제를 제출한 선생님의 이름을 뽑아온다.
        String adivision = "B"; // 종류는 A or B 이므로 과제를 표현할때는 B 값을 넣기위한 세팅

        List<String> sidlist = classService.selectSidS(sucode); // 알림 기능을 위해 해당 수업 코드에 해당 하는 학생 id 리스트 로 뽑아 온다.



        if(!ofname.equals("")) {
            log.info("#ofname 넘어오냐?"+ofname);
            boardVo.setTid(tid);
            boardVo.setThcode(thcode);
            boardVo.setSucode(sucode);
            ofname = ofname.trim();
            String url = fileUploadService.saveStore(file, boardVo);
            log.info("#url: "+url);
            log.info("#thcode: "+boardVo.getThcode());

            //알림 기능 구현

            boardService.insertBoardOkFileS(boardVo);

            return "redirect:../list/myclass.do?sucode="+sucode;
        }else {
            boardVo.setTid(tid);
            boardVo.setThcode(thcode);
            boardVo.setSucode(sucode);
            boardService.insertBoardNotFileS(boardVo);
            log.info("#bseq!!: "+boardVo.getBseq());
            if(sidlist.size()>0) { // 만약 0 번째 주소에 값이 null 이 아니면 -> list 는 0번째 부터 들어 가니깐 0 != null 이라는건 학생이 한명 이상 존재 한다는 뜻!
                if(sidlist.get(0)!=null) {
                    for(int i =0; i<sidlist.size();i++) { // 뽑아온 학생의 수만큼 반목문 수행.
                        alarmVo.setAtname(tname); // 선생님 이름
                        alarmVo.setAsuname(suname); // 과목명
                        alarmVo.setAdivision(adivision); // 종류
                        alarmVo.setSucode(sucode); // 과목 코드
                        alarmVo.setSid(sidlist.get(i)); // list 0번째 값부터 list의 크기만큼
                        alarmVo.setBseq(boardVo.getBseq());
                        alarmService.ainsertS(alarmVo); // Alarm Table에 insert 해준다.
                    }
                }
            }
            return "redirect:../list/myclass.do?sucode="+sucode;
        }
    }



    //기한이 있는 자료(==과제) 인서트(선생님, board 테이블)
    @PostMapping("/assignin.do")
    public String assignIn(ThemeVo themeVo, @RequestParam("themelist")String thcode,
                           HttpSession session, @RequestParam("rdeadline")String rdeadline, BoardVo boardVo,
                           AlarmVo alarmVo, MultipartFile file ) { // 알림 사용을 위해 AlarmVo 선언

        String ofname = file.getOriginalFilename();

        Object code = session.getAttribute("sucode");
        Object id = session.getAttribute("loginOkTid");
        String sucode = (String)code;
        String tid = (String)id;
        log.info("가온나"+thcode+tid);

        String suname = subjectService.selectSunameS(sucode); // 해당하는 과목코드를 이용해 과목 이름을 뽑아온다.
        log.info("수코드로 가져온 수네임"+suname);
        String tname = teacherService.tnameS(tid); // session을 이용해서  과제를 제출한 선생님의 이름을 뽑아온다.
        String adivision = "A"; // 종류는 A or B 이므로 과제를 표현할때는 A 값을 넣기위한 세팅

        List<String> sidlist = classService.selectSidS(sucode); // 해당 수업 코드에 해당 하는 학생 id 리스트 로 뽑아 온다.
        if(sidlist.size()>0) {
            if (sidlist.get(0) != null) { // 만약 0 번째 주소에 값이 null 이 아니면 -> list 는 0번째 부터 들어 가니깐 0 != null 이라는건 학생이 한명 이상 존재 한다는 뜻!
                for (int i = 0; i < sidlist.size(); i++) { // 뽑아온 학생의 수만큼 반목문 수행.
                    alarmVo.setAtname(tname); // 선생님 이름
                    alarmVo.setAsuname(suname); // 과목명
                    alarmVo.setAdivision(adivision); // 종류
                    alarmVo.setSucode(sucode); // 과목 코드
                    alarmVo.setSid(sidlist.get(i)); // list 0번째 값부터 list의 크기만큼
                    alarmService.ainsertS(alarmVo); // Alarm Table에 insert 해준다.
                }
            }
        }


        int d = Integer.parseInt(rdeadline); // 과제기한 values 값을 int형으로 변환


        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd");
        cal.add(Calendar.DATE, d);
        Date day = new Date(cal.getTimeInMillis());
        boardVo.setTid(tid);
        boardVo.setThcode(thcode);
        boardVo.setBdeadline(day);
        boardVo.setSucode(sucode);

        if(!ofname.equals("")) {
            log.info("#arrin ofname: "+ofname);
            ofname = ofname.trim();
            String url = fileUploadService.saveStore(file, boardVo);
            log.info("#arrin url: "+url);
            log.info("#arrin thcode: "+boardVo.getThcode());
            boardService.insertOkFileS(boardVo);
            return "redirect:../list/myclass.do?sucode="+sucode+"";
        }
        else {
            boardService.insertNotFileS(boardVo);
            return "redirect:../list/myclass.do?sucode="+sucode+"";
        }

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
