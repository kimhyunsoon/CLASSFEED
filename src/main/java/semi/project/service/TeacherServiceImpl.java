package semi.project.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.TeacherVo;
import semi.project.mapper.TeacherMapper;

@Service
@Log4j
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

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
		log.info("check this");
		teacherMapper.tinsert(teacherVo);
	}

	@Override
	public String temailckS(String temail) {
		log.info("여기까진 오니???");
		String tEmail = teacherMapper.temailck(temail);
		log.info(tEmail);
		if(tEmail==null){
			return "noEmail";
		}else{
			return "yesEmail";
		}
	}

	@Override
	public String tidckS2(String tid) {
		String tId = teacherMapper.tidck(tid);
		log.info(tId);
		if(tId==null){
			return "noId";
		}else{
			return "yesId";
		}
	}


}
