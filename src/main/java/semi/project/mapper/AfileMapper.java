package semi.project.mapper;

import org.springframework.stereotype.Repository;
import semi.project.domain.AfileVo;

@Repository
public interface AfileMapper {
	void fileUpload(AfileVo afileVo);
}
