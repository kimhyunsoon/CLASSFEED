package semi.project.mapper;

import java.util.List;

import semi.project.domain.AlarmVo;

public interface AlarmMapper {
	void ainsert(AlarmVo alarmVo);
	List<AlarmVo> aselectBysid(String sid);
}
