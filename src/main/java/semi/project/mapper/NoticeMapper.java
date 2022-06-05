package semi.project.mapper;


import org.springframework.stereotype.Repository;
import semi.project.domain.NoticeVo;

import java.util.List;

@Repository
public interface NoticeMapper {

    List<NoticeVo> selectNoticeBySucode(String sucode);
    void insertNoticeByStudent(NoticeVo noticeVo);
    void insertNoticeByTeacher(NoticeVo noticeVo);
    void deleteNoticeBynSeqS(long nseq);






    List<NoticeVo> selectBySucode(String sucode);


}
