package semi.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassVo { // 학생 수업관리
	private String sucode; // 과목코드
	private String sid; // 학생아이디
}
