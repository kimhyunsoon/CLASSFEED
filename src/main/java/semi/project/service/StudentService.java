package semi.project.service;

import java.util.List;

import semi.project.domain.StudentVo;

public interface StudentService {
	StudentVo sloginS(String sid, String spwd); // 로그인용
	String sidckS(String sid); // 선생 or 학생 구분
	void sinsertS(StudentVo studentVo); // 회원가입
}
