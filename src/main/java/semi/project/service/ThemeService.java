package semi.project.service;

import java.util.List;

import semi.project.domain.ThemeVo;

public interface ThemeService {
    List<ThemeVo> selectThemeBySucode(String sucode);

    String selectByThcodeS(String thcode);
	List<ThemeVo> selectAllS(String thcode);
	void thinsertS(ThemeVo themeVo);
	List<ThemeVo> selectBysucodeS(String sucode);

	List<ThemeVo> selectByTidS(String tid, String sucode);
	List<ThemeVo> selectAllClassS(String sucode);
	public Boolean chkThcode(String thcode);
}
