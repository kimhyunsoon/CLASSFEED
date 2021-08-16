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
	public String sloginS(String sid, String spwd) {
		log.info("#servicesid"+sid);
		log.info("#servicespwd"+spwd); //클라이언트에서 받아온 정보
		StudentVo studentVo = studentMapper.slogin(sid, spwd);
		if(studentVo!= null){
			String checkSid = studentVo.getSid();
			String checkSpwd = studentVo.getSpwd(); //select를 해서 받아온 정보
			log.info("#checksId"+checkSid);
			log.info("#checksPwd"+checkSpwd);
			if(sid.equals(checkSid) && spwd.equals(checkSpwd)){
				return "success";
			}else{
				return "fail";
			}
		}else {
			return "fail";

		}

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

	@Override
	public List<StudentVo> sNameCkS(String sid) {
		return studentMapper.sNameCk(sid);
	}

}
