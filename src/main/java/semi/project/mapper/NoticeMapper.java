package semi.project.mapper;


import org.springframework.stereotype.Repository;
import semi.project.domain.NoticeVo;

@Repository
public interface NoticeMapper {
    void insertNotice(NoticeVo noticeVo);
}
