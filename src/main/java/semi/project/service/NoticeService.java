package semi.project.service;

import java.util.List;

import semi.project.domain.BoardVo;
import semi.project.domain.NoticeVo;

public interface NoticeService {

    List<NoticeVo> selectNoticeBySucode(String sucode);
    void insertNoticeByStudent(NoticeVo noticeVo);
    void insertNoticeByTeacher(NoticeVo noticeVo);









    //	List<NoticeVo> selectAllS(long nseq);
//	List<NoticeVo> nolistS();
//	void tnoinsertS(NoticeVo noticeVo);
//	void snoinsertS(NoticeVo noticeVo);

	List<NoticeVo> selectBySucode(String sucode);

    void deleteNoticeBynSeq(long nseq);
}
