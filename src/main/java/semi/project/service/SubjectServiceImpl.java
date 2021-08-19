package semi.project.service;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;
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
		log.info("kkkkkkkkkkk");
		return subjectMapper.selectAll(sucode);
	}

	@Override
	public List<TeacherVo> selectTnameS(String sucode) {
		return subjectMapper.selectTname(sucode);
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

	@Override
	public Boolean chkSucode(String sucode) {
		String code= subjectMapper.selectBySucode(sucode);
		log.info("#code"+code);
		if(code==null){
			return true;
		}else{
			return false;
		}

	}

	@Override
	public String selectSunameS(String sucode) {
		// TODO Auto-generated method stub
		return subjectMapper.selectSuname(sucode);
	}

	@Override
	public String selectTidS(String sucode) {
		// TODO Auto-generated method stub
		return subjectMapper.selectTid(sucode);
	}

	@Override
	public void updateKeepOnS(String skeep, String sucode) {
		log.info("킵온 코드"+skeep);
		log.info("킵온 수코드"+sucode);
		subjectMapper.updateKeepOn(skeep, sucode);
	}

	@Override
	public void updateKeepOffS(String skeep, String sucode) {
		log.info("킵오프 코드"+skeep);
		log.info("킵오프 수코드"+sucode);
		subjectMapper.updateKeepOff(skeep, sucode);
	}


}
