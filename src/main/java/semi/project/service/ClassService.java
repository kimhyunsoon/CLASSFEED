package semi.project.service;

import java.util.List;

import semi.project.domain.ClassVo;
import semi.project.domain.SubjectVo;

public interface ClassService {
	List<SubjectVo> selectBySucodeS(String sucode);
	List<String> selectBySidS(String sid);
	void insertS(ClassVo classVo);
//	String selectTname(String sucode);
}
