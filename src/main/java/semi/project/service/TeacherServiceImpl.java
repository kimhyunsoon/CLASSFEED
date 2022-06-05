package semi.project.service;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.TeacherVo;
import semi.project.mapper.TeacherMapper;

@Service
@Log4j

public class TeacherServiceImpl implements TeacherService {

	private TeacherMapper teacherMapper;

	public TeacherServiceImpl(TeacherMapper teacherMapper){
		this.teacherMapper = teacherMapper;
	}

	@Override
	public List<TeacherVo> selectTeacherListByTid(String tid) {
		List<TeacherVo> teacherVoList = new ArrayList<>();
		TeacherVo teacherVo= teacherMapper.selectTeacherByTid(tid);
		teacherVoList.add(teacherVo);
		return teacherVoList;
	}

	@Override
	public int validateTeacherExist(String tid) {
		return teacherMapper.countTeacherByTid(tid);
	}

	@Override
	public TeacherVo selectTeacherByTid(String tid) {
		return teacherMapper.selectTeacherByTid(tid);
	}










	
	@Override
	public String tloginS(String tid, String tpwd) {
		log.info("#servicetid"+tid);
		log.info("#servicepwd"+tpwd); //클라이언트에서 받아온 정보
		TeacherVo teacherVo = teacherMapper.tlogin(tid, tpwd);
		if(teacherVo!=null){
			String checkId = teacherVo.getTid();
			String checkPwd = teacherVo.getTpwd(); //select를 해서 받아온 정보
			log.info("#checkId"+checkId);
			log.info("#checkPwd"+checkPwd);
			log.info(checkId);
			if(tid.equals(checkId) && tpwd.equals(checkPwd)){
				return "success";
			}else{
				return "fail";
			}
		}else {
			return "fail";

		}

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
	public TeacherVo tlnfoS(String tid) {
		// TODO Auto-generated method stub
		TeacherVo teacherVo = teacherMapper.tlnfo(tid);
		return teacherVo;
	}


	@Override
	public String temailckS(String temail) {
		String tEmail = teacherMapper.temailck(temail);
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

	@Override
	public List<TeacherVo> tNameCkS(String tid) {
		return teacherMapper.tNameCk(tid);
	}


	@Override
	public String tnameS(String tid) {
		// TODO Auto-generated method stub
		return teacherMapper.tname(tid);
	}



}
