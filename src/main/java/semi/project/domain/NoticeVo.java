package semi.project.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeVo { // 공지
	private long nseq; // 공지 번호
	private String rcontent; // 공지 내용
	private Date nrdate; // 작성 날짜
	private String tid; // 선생님 아이디
	private String sid; // 학생 아이디
}
