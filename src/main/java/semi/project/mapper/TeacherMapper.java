package semi.project.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import semi.project.domain.TeacherVo;


@Repository
public interface TeacherMapper {

	int countTeacherByTid (String tid);
	TeacherVo selectTeacherByTid (String tid);
	TeacherVo selectTeacherBybSeq (long bseq);









	TeacherVo tlogin(String arg0, String arg1);
	String tidck(String tid); // 선생 or 학생 구분
	void tinsert(TeacherVo teacherVo);
	TeacherVo tlnfo(String tid);
	//추가
	String temailck(String temail);
	List<TeacherVo> tNameCk(String tid);
	String tname(String tid);
}
