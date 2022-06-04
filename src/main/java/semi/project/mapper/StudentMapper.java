package semi.project.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import semi.project.domain.StudentVo;
import semi.project.domain.TeacherVo;

@Repository
public interface StudentMapper {
	List<StudentVo> selectStudentBySid(String sid);












	StudentVo slogin(String arg0, String arg1); // 로그인용
	String sidck(String sid); // 선생 or 학생 구분
	void sinsert(StudentVo studentVo); // 회원가입
	//추가
	String semailck(String semail);
	List<StudentVo> sNameCk(String sid);
	String selectBySid(String sid);
}
