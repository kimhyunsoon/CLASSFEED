package semi.project.service;

import java.util.List;

import semi.project.domain.TeacherVo;

public interface TeacherService {
	List<TeacherVo> selectTeacherListByTid(String tid);

	int validateTeacherExist(String tid);

	TeacherVo selectTeacherByTid(String tid);












	String tloginS(String tid, String tpwd);
	String tidckS(String tid); // 선생 or 학생 구분
	void tinsertS(TeacherVo teacherVo);
	TeacherVo tlnfoS(String tid);

	//추가
	String temailckS(String temail);
	String tidckS2(String tid);
	List<TeacherVo> tNameCkS(String tid);
	String tnameS(String tid);

}
