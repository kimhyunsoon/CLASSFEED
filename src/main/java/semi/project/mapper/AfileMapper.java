package semi.project.mapper;

import org.springframework.stereotype.Repository;
import java.util.List;

import semi.project.domain.AfileVo;

@Repository
public interface AfileMapper {
	void fileUpload(AfileVo afileVo);
	List<AfileVo> afileSelectBySeq(long bseq);
	List<AfileVo> afileSelectBySid(AfileVo afileVo);
}
