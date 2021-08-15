package semi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.ThemeVo;
import semi.project.mapper.ThemeMapper;

@Service
public class ThemeServiceImpl implements ThemeService {
	@Autowired
	private ThemeMapper themeMapper;

	@Override
	public String selectByThcodeS(String thcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ThemeVo> selectAllS(String thcode) {
		return themeMapper.selectAll(thcode);
		}

	@Override
	public void thinsertS(ThemeVo themeVo) {
		themeMapper.thinsert(themeVo);

	}

	@Override
	public List<ThemeVo> selectBysucodeS(String sucode) {
		// TODO Auto-generated method stub
		return themeMapper.selectBysucode(sucode);
	}

}
