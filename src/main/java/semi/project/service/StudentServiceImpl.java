package semi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.StudentVo;
import semi.project.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public StudentVo sloginS(String sid, String spwd) {
		StudentVo studentVo = studentMapper.slogin(sid, spwd);
		return studentVo;
	}

	@Override
	public String sidckS(String sid) {
		// TODO Auto-generated method stub
		return studentMapper.sidck(sid);
	}

	@Override
	public void sinsertS(StudentVo studentVo) { // 회원 가입
		// TODO Auto-generated method stub
		studentMapper.sinsert(studentVo);
	}

}
