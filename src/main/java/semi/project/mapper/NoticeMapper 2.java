package semi.project.mapper;


import org.springframework.stereotype.Repository;
import semi.project.domain.NoticeVo;

import java.util.List;

@Repository
public interface NoticeMapper {
    void insertByStu(NoticeVo noticeVo);
    void insertByTeacher(NoticeVo noticeVo);
    List<NoticeVo> selectBySucode(String sucode);
}
