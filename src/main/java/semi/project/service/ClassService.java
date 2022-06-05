package semi.project.service;

import java.util.List;

import semi.project.domain.ClassVo;
import semi.project.domain.SubjectVo;

public interface ClassService {
    List<ClassVo> selectClassBySid(String sid);

    List<String> selectSucodeBySid(String sid);

    void insertClass(ClassVo classVo);

    List<SubjectVo> selectBySucodeS(String sucode);
	List<String> selectBySidS(String sid);
	void insertS(ClassVo classVo);
	List<String> selectSidS(String sucode);
}
