package semi.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVo { // 댓글
	private long cseq; // 댓글 번호
	private long bseq; // 자료 번호
	private long aseq; // 과제 번호
	private String sid; // 학생 아이디
	private String tid; // 선생 아이디
	private String com; // 내용
}
