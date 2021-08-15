package semi.project.service;

import java.util.List;

import semi.project.domain.TeacherVo;

public interface TeacherService {
	TeacherVo tloginS(String tid, String tpwd);
	String tidckS(String tid); // 선생 or 학생 구분
	void tinsertS(TeacherVo teacherVo);
	String temailckS(String temail);
}
