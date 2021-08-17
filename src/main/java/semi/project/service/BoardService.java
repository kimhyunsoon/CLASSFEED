package semi.project.service;

import semi.project.domain.BoardVo;

import java.util.List;

public interface BoardService {
    void insertNotFileS(BoardVo boardVo);
    void insertBoardNotFileS(BoardVo boardVo);
    List<BoardVo> selectBySucode(String sucode);
}
