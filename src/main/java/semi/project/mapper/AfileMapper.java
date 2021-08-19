package semi.project.mapper;

import org.springframework.stereotype.Repository;
import java.util.List;

import semi.project.domain.AfileVo;

@Repository
public interface AfileMapper {
	void fileUpload(AfileVo afileVo);
	List<AfileVo> SelectBySeq(long bseq);
}
