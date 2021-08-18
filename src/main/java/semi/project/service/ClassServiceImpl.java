package semi.project.service;

import java.util.List;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.ClassVo;
import semi.project.domain.SubjectVo;
import semi.project.mapper.ClassMapper;

@Log4j
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassMapper classMapper;
	
	@Override
	public List<SubjectVo> selectBySucodeS(String sucode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertS(ClassVo classVo) {
		// TODO Auto-generated method stub
		classMapper.cinsert(classVo);
	}


	@Override
	public List<String> selectBySidS(String sid) {
		// TODO Auto-generated method stub
		return classMapper.selectBySid(sid);
	}

	@Override
	public List<String> selectSidS(String sucode) {
		// TODO Auto-generated method stub
		return classMapper.selectSid(sucode);
	}




}
