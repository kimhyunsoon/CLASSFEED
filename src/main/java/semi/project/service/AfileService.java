package semi.project.service;

import semi.project.domain.AfileVo;

import java.util.List;

public interface AfileService {
	void fileUploadS(AfileVo afileVo);
	List<AfileVo> SelectBySeqS(long bseq);
}
