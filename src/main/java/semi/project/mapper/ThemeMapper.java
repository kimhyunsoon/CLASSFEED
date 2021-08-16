package semi.project.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import semi.project.domain.ThemeVo;


@Repository
public interface ThemeMapper {
	
	String selectByThcode(String thcode);
	List<ThemeVo> selectAll(String thcode);
	void thinsert(ThemeVo themeVo);
	
	List<ThemeVo> selectBysucode(String sucode);

}
