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
	@Autowired
	private NoticeMapper noticeMapper;


	@Override
	public void insertNotice(NoticeVo noticeVo) {
		noticeMapper.insertNotice(noticeVo);

	}
}