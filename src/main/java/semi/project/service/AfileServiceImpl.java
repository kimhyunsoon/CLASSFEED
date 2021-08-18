package semi.project.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import semi.project.domain.AfileVo;
import semi.project.mapper.AfileMapper;


@Service
@AllArgsConstructor
@Log4j
public class AfileServiceImpl implements AfileService {
	private AfileMapper AfileMapper;
	@Override
	public void fileUploadS(AfileVo afileVo) {
		// TODO Auto-generated method stub
		AfileMapper.fileUpload(afileVo);
	}

}
