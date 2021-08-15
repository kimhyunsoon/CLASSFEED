package semi.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.SubjectVo;
import semi.project.mapper.SubjectMapper;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectMapper subjectMapper;
	@Override
	public String selectBySucodeS(String sucode) {
		// TODO Auto-generated method stub
		return subjectMapper.selectBySucode(sucode);
	}

	@Override
	public String selectBySkeepS(String sucode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectVo> selectAllS(String sucode) {
		// TODO Auto-generated method stub
		return subjectMapper.selectAll(sucode);
	}

	@Override
	public void suinsertS(SubjectVo subjectVo) {
		// TODO Auto-generated method stub
		subjectMapper.suinsert(subjectVo);
	}

	@Override
	public List<SubjectVo> testAll(String sucode) {
		// TODO Auto-generated method stub
		return subjectMapper.testAll(sucode);
	}

	@Override
	public List<SubjectVo> selectBytid(String tid) {
		// TODO Auto-generated method stub
		return subjectMapper.selectBytid(tid);
	}

}
