package semi.project.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo { // 자료
	private long bseq; // 번호
	private String tid; // 선생님 아이디
	private String thcode; // 주제 코드
	private String btitle; // 제목
	private String bcontent; // 내용
	private Date brdate; // 작성 날짜
	private Date bdeadline;
	
	private String bfname; // 기본 파일 이름
	private String bofname; // 변경된 파일 이름
	private long bfsize; // 파일 크기
	private String sucode;
}
