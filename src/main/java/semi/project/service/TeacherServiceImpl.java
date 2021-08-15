package semi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.TeacherVo;
import semi.project.mapper.TeacherMapper;

@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherMapper teacherMapper;
	
	@Override
	public TeacherVo tloginS(String tid, String tpwd) {
		TeacherVo teacherVo = teacherMapper.tlogin(tid, tpwd);
		return teacherVo;
	}

	@Override
	public String tidckS(String tid) {
		// TODO Auto-generated method stub
		return teacherMapper.tidck(tid);
	}

	@Override
	public void tinsertS(TeacherVo teacherVo) {
		teacherMapper.tinsert(teacherVo);
	}

}
