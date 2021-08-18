package semi.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfileVo {
	private String afname; // 파일이름
	private String sid; // 학생 아이디
	private long afsize; // 파일 크기
	private String bseq; // 자료&과제 테이블 seq
}
