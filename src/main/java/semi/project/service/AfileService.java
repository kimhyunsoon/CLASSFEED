package semi.project.service;

import semi.project.domain.AfileVo;

import java.util.List;

public interface AfileService {
	void fileUploadS(AfileVo afileVo);
	List<AfileVo> afileSelectBySeqS(long bseq);
	List<AfileVo> afileSelectBySids(AfileVo afileVo);
	void deleteByAfName(String afname);
}
