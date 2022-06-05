package semi.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import semi.project.domain.ClassVo;
import semi.project.domain.SubjectVo;


@Repository
public interface ClassMapper {

	int countClassByStudent(ClassVo classVo);
	List<ClassVo> selectClassBySid(String sid);
	List<String> selectSucodeBySid(String sid);
	void insertClass(ClassVo classVo);












	List<SubjectVo> selectBySucode(String sucode);
	List<String> selectBySid(String sid);

	void cinsert(ClassVo classVo);
	List<String> selectSid(String sucode);

}
