package semi.project.service;

import java.util.List;

import semi.project.domain.AlarmVo;

public interface AlarmService {
	void ainsertS(AlarmVo alarmVo);
	List<AlarmVo> aselectBysidS(String sid);
}
