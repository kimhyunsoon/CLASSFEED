package semi.project.service;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.SubjectVo;
import semi.project.mapper.SubjectMapper;

@Service
@Log4j
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {


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
