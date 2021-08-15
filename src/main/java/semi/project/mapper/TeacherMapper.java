package semi.project.mapper;

import java.util.List;

import semi.project.domain.TeacherVo;

public interface TeacherMapper {
	TeacherVo tlogin(String arg0, String arg1);
	String tidck(String tid); // 선생 or 학생 구분
	void tinsert(TeacherVo teacherVo);
}
