package semi.project.service;

import semi.project.domain.BoardVo;

import java.util.List;

public interface BoardService {
    void insertBoardOkFileS(BoardVo boardVo);
    void insertBoardNotFileS(BoardVo boardVo);
    void insertNotFileS(BoardVo boardVo);
    void insertOkFileS(BoardVo boardVo);
    void deleteBySeqS(long bseq);
    BoardVo getBoardS(long bseq);

    List<BoardVo> boardSelectAllS(String tid, String sucode);
    List<BoardVo> boardSelectClassS(String sucode);
    List<BoardVo> selectBySucode(String sucode);
    String boardSelectTidS(long bseq);
    List<BoardVo> boardSelectBySeqS(long bseq);

    void boardUpdateS(BoardVo boardVo);
}
