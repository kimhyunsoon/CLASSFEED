package semi.project.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import semi.project.domain.AfileVo;
import semi.project.mapper.AfileMapper;

import java.util.List;


@Service
@AllArgsConstructor
@Log4j
public class AfileServiceImpl implements AfileService {
	private AfileMapper afileMapper;
	@Override
	public void fileUploadS(AfileVo afileVo) {
		// TODO Auto-generated method stub
		log.info("앞뒤로");
		log.info("이쯤에서 afile: "+afileVo);
		afileMapper.fileUpload(afileVo);
		log.info("포위");
	}

	@Override
	public List<AfileVo> SelectBySeqS(long bseq) {
		return afileMapper.SelectBySeq(bseq);
	}

}
