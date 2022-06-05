package semi.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import semi.project.domain.ThemeVo;


@Repository
public interface ThemeMapper {

	List<ThemeVo> selectThemeBySucode(String sucode);
	int countThemeByThcode(String thcode);
	void insertTheme(ThemeVo themeVo);









	String selectByThcode(String thcode);
	List<ThemeVo> selectAll(String thcode);
	void thinsert(ThemeVo themeVo);

	List<ThemeVo> selectBysucode(String sucode);

	List<ThemeVo> selectByTid(@Param("tid")String tid, @Param("sucode")String sucode);
	List<ThemeVo> selectAllClass(String sucode);


}
