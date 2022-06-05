package semi.project.service;

import java.util.List;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.NoticeVo;
import semi.project.mapper.NoticeMapper;

@Log4j
@Service
public class NoticeServiceImpl implements NoticeService {

	private NoticeMapper noticeMapper;

	public NoticeServiceImpl(NoticeMapper noticeMapper){
		this.noticeMapper = noticeMapper;
	}


	@Override
	public List<NoticeVo> selectNoticeBySucode(String sucode) {
		return noticeMapper.selectNoticeBySucode(sucode);
	}


	@Override
	public void insertNoticeByStudent(NoticeVo noticeVo) {
		noticeMapper.insertNoticeByStudent(noticeVo);
	}

	@Override
	public void insertNoticeByTeacher(NoticeVo noticeVo) {
		noticeMapper.insertNoticeByTeacher(noticeVo);
	}

	@Override
	public void deleteNoticeBynSeq(long nseq) {
		// TODO Auto-generated method stub
		noticeMapper.deleteNoticeBynSeqS(nseq);
	}

















	@Override
	public List<NoticeVo> selectBySucode(String sucode) {
		return noticeMapper.selectBySucode(sucode);
	}



}