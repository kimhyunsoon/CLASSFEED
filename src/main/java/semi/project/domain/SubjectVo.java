package semi.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectVo { // 과목
	private String sucode; // 과목코드
	private String tid; // 선생님 아이디
	private String suname; // 과목명
	private String ssubname; // 부제목
	private String skeep; // 보관 y/n
}
