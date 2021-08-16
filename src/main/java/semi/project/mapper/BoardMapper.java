package semi.project.mapper;


import org.springframework.stereotype.Repository;
import semi.project.domain.BoardVo;

@Repository
public interface BoardMapper {
    void insertNotFile(BoardVo boardVo);
    void insertBoardNotFile(BoardVo boardVo);
}
