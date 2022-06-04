package semi.project.service;

import java.util.List;

import semi.project.domain.StudentVo;
import semi.project.domain.TeacherVo;

public interface StudentService {
	List<StudentVo> selectStudentBySid(String sid);

	String sloginS(String sid, String spwd); // 로그인용
	String sidckS(String sid); // 선생 or 학생 구분
	void sinsertS(StudentVo studentVo); // 회원가입
	//추가
	String semailckS(String semail);
	String sidckS2(String sid);
	List<StudentVo> sNameCkS(String sid);
	String selectBySidS(String sid);
}
