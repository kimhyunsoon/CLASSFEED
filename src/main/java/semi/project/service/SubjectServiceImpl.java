package semi.project.service;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import semi.project.domain.StudentRandom;
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
	public int validateSubjectExist(String sucode){
		return subjectMapper.countSubjectBySucode(sucode);
	}


	@Override
	public List<SubjectVo> selectSubjectByTid(String tid) {
		// TODO Auto-generated method stub
		return subjectMapper.selectSubjectByTid(tid);
	}
	@Override
	public List<SubjectVo> selectSubjectBySucodeList(String sucode) {
		// TODO Auto-generated method stub
		List<SubjectVo> subjectVoList = new ArrayList<>();
		subjectVoList.add(subjectMapper.selectSubjectBySucode(sucode));
		return subjectVoList;
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
	public void insertSubject(SubjectVo subjectVo){
		String sucode = "";
		StudentRandom random = new StudentRandom();
		char[] num = random.ran(); // 랜덤 과목코드 생성

		if (num == null) {
			this.insertSubject(subjectVo);
		}
		for (int i = 0; i < num.length; i++) {
			sucode += Character.toString(num[i]);
		}
		sucode = sucode.trim();
		if (subjectMapper.countSubjectBySucode(sucode) > 0) {
			this.insertSubject(subjectVo);
		}
		subjectVo.setSucode(sucode); // sucode 값 셋팅
		subjectMapper.insertSubject(subjectVo); // 과목  insert
	}


	@Override
	public void updateSubjectKeepOn(String skeep, String sucode) {
		subjectMapper.updateSubjectKeepOn(skeep, sucode);
	}

	@Override
	public void updateSubjectKeepOff(String skeep, String sucode) {
		subjectMapper.updateSubjectKeepOff(skeep, sucode);
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



}
