package semi.project.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.StudentVo;
import semi.project.mapper.StudentMapper;

@Service
@Log4j
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

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

	@Override
	public String semailckS(String semail) {
		log.info("여기까진 오니???");
		String sEmail = studentMapper.semailck(semail);
		log.info(sEmail);
		if(sEmail==null){
			return "noEmail";
		}else{
			return "yesEmail";
		}
	}

	@Override
	public String sidckS2(String sid) {
		String sId = studentMapper.sidck(sid);
		log.info(sId);
		if(sId==null){
			return "noId";
		}else{
			return "yesId";
		}
	}

}
