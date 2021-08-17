package semi.project.mapper;


import org.springframework.stereotype.Repository;
import semi.project.domain.BoardVo;


import java.util.List;

@Repository
public interface BoardMapper {
    void insertNotFile(BoardVo boardVo);
    void insertBoardNotFile(BoardVo boardVo);
    List<BoardVo> selectBySucode(String sucode);

}
