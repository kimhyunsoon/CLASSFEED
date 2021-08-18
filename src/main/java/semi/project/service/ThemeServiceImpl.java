package semi.project.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.project.domain.ThemeVo;
import semi.project.mapper.ThemeMapper;

@Service
@Log4j
@AllArgsConstructor
public class ThemeServiceImpl implements ThemeService {

	private ThemeMapper themeMapper;

	@Override
	public String selectByThcodeS(String thcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean chkThcode(String thcode){
		String code=themeMapper.selectByThcode(thcode);
		log.info("#code"+code);
		if(code==null){
			return true;
		}else{
			return false;
		}
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

	@Override
	public List<ThemeVo> selectByTidS(String tid, String sucode) {
		// TODO Auto-generated method stub
		List<ThemeVo> list = themeMapper.selectByTid(tid, sucode);
		return list;
	}









	@Override
	public List<ThemeVo> selectAllClassS(String sucode) {
		// TODO Auto-generated method stub
		return themeMapper.selectAllClass(sucode);
	}


}
