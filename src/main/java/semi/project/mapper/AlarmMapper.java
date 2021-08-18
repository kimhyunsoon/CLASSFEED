package semi.project.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import semi.project.domain.AlarmVo;

@Repository
public interface AlarmMapper {
	void ainsert(AlarmVo alarmVo);
	List<AlarmVo> aselectBysid(String sid);
}
