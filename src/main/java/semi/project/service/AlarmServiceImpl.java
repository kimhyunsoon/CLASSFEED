package semi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.AlarmVo;
import semi.project.mapper.AlarmMapper;

@Service
public class AlarmServiceImpl implements AlarmService {
	@Autowired
	private AlarmMapper alarmMapper;
	@Override
	public void ainsertS(AlarmVo alarmVo) {
		// TODO Auto-generated method stub
		alarmMapper.ainsert(alarmVo);
	}

	@Override
	public List<AlarmVo> aselectBysidS(String sid) {
		// TODO Auto-generated method stub
		return alarmMapper.aselectBysid(sid);
	}

}
