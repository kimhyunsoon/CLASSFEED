package semi.project.service;

import java.util.ArrayList;
import java.util.List;

import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;

public interface SubjectService {
	String selectBySucodeS(String sucode);
	String selectBySkeepS(String sucode);
	
	List<SubjectVo> selectAllS(String sucode);
	List<TeacherVo> selectTnameS(String sucode);
	void suinsertS(SubjectVo subjectVo);
	
	List<SubjectVo> testAll(String sucode);
	List<SubjectVo> selectBytid(String tid);
	Boolean chkSucode(String sucode);
}
