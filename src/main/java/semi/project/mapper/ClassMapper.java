package semi.project.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import semi.project.domain.ClassVo;
import semi.project.domain.SubjectVo;


@Repository
public interface ClassMapper {
	List<SubjectVo> selectBySucode(String sucode);
	List<String> selectBySid(String sid);

	void cinsert(ClassVo classVo);
	List<String> selectSid(String sucode);

}
