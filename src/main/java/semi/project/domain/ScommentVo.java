package semi.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScommentVo { // 비밀 댓글
	private long scseq; // 비밀 댓글 번호
	private long aseq; // 과제 번호
	private String tid; // 선생님 아이디
	private String sid; // 학생 아이디
	private String scom; // 댓글
}
