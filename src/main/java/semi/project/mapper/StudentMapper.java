package semi.project.mapper;

import java.util.List;

import semi.project.domain.StudentVo;

public interface StudentMapper {
	StudentVo slogin(String arg0, String arg1); // 로그인용
	String sidck(String sid); // 선생 or 학생 구분
	void sinsert(StudentVo studentVo); // 회원가입
}
