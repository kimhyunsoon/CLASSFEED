package semi.project.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;

public interface SubjectService {
    int validateSubjectExist(String sucode);

    List<SubjectVo> selectSubjectByTid(String tid);
	List<SubjectVo> selectSubjectBySucodeList(String sucode);
	List<SubjectVo> selectAttendedSubject(List<String> sucodeList);

	void insertSubject(SubjectVo subjectVo);

	void updateSubjectKeepOn(@Param("skeep")String skeep, @Param("sucode")String sucode);
	void updateSubjectKeepOff(@Param("skeep")String skeep, @Param("sucode")String sucode);














	String selectBySucodeS(String sucode);
	String selectBySkeepS(String sucode);
	
	List<SubjectVo> selectAllS(String sucode);
	List<TeacherVo> selectTnameS(String sucode);
	void suinsertS(SubjectVo subjectVo);
	
	List<SubjectVo> testAll(String sucode);
	List<SubjectVo> selectBytid(String tid);
	Boolean chkSucode(String sucode);

	String selectSunameS(String sucode);

	String selectTidS(String sucode);

}
