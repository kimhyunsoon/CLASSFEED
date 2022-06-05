package semi.project.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;


@Repository
public interface SubjectMapper {
	List<SubjectVo> selectSubjectByTid(String tid);
	SubjectVo selectSubjectBySucode(String sucode);

	void updateSubjectKeepOn(@Param("skeep")String skeep, @Param("sucode")String sucode);
	void updateSubjectKeepOff(@Param("skeep")String skeep, @Param("sucode")String sucode);

















	String selectBySucode(String sucode);
	String selectBySkeep(String sucode);
	
	//List<SubjectVo>[] selectAll(String sucode);
	void suinsert(SubjectVo subjectVo);
	List<SubjectVo> selectAll(String sucode);
	List<TeacherVo> selectTname(String sucode);

	
	List<SubjectVo> testAll(String sucode);
	List<SubjectVo> selectBytid(String tid);
	String selectSuname(String sucode);
	String selectTid(String sucdoe); // 선생님 id 찾기위해


}
