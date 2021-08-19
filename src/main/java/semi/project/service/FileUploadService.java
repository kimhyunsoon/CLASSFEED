package semi.project.service;

import org.springframework.web.multipart.MultipartFile;

import semi.project.domain.AfileVo;
import semi.project.domain.BoardVo;

public interface FileUploadService {
	String saveStore(MultipartFile file, BoardVo boardVo);
	String sSaveStore(MultipartFile file, AfileVo afileVo);

	boolean writeFile(MultipartFile file, String saveFileName);
}
