package semi.project.service;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;
import semi.project.mapper.SubjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class SubjectServiceImpl implements SubjectService {


	private SubjectMapper subjectMapper;

	public SubjectServiceImpl(SubjectMapper subjectMapper){
		this.subjectMapper = subjectMapper;
	}

	@Override
	public List<SubjectVo> selectSubjectByTid(String tid) {
		// TODO Auto-generated method stub
		return subjectMapper.selectSubjectByTid(tid);
	}
	@Override
	public SubjectVo selectSubjectBySucode(String sucode) {
		// TODO Auto-generated method stub
		return subjectMapper.selectSubjectBySucode(sucode);
	}

	@Override
	public List<SubjectVo> selectAttendedSubject(List<String> sucodeList) {
		List<SubjectVo> subjectVoList = new ArrayList<>();
		for(String sucode : sucodeList){
			SubjectVo subjectVo= subjectMapper.selectSubjectBySucode(sucode);
			subjectVoList.add(subjectVo);
		}
		return subjectVoList;
	}















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
	public void updateSubjectKeepOn(String skeep, String sucode) {
		subjectMapper.updateSubjectKeepOn(skeep, sucode);
	}

	@Override
	public void updateSubjectKeepOff(String skeep, String sucode) {
		subjectMapper.updateSubjectKeepOff(skeep, sucode);
	}


}
