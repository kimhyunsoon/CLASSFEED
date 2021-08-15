package semi.project.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import semi.project.domain.StudentVo;

@Repository
public interface StudentMapper {
	StudentVo slogin(String arg0, String arg1); // 로그인용
	String sidck(String sid); // 선생 or 학생 구분
	void sinsert(StudentVo studentVo); // 회원가입
	//추가
	String semailck(String semail);
}
