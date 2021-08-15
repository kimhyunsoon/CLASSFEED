package semi.project.mapper;

import java.util.ArrayList;
import java.util.List;

import semi.project.domain.SubjectVo;

public interface SubjectMapper {
	String selectBySucode(String sucode);
	String selectBySkeep(String sucode);
	
	//List<SubjectVo>[] selectAll(String sucode);
	void suinsert(SubjectVo subjectVo);
	List<SubjectVo> selectAll(String sucode);
	
	List<SubjectVo> testAll(String sucode);
	List<SubjectVo> selectBytid(String tid);
}
