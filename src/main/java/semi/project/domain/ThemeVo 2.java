package semi.project.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThemeVo { // 주제
	private String thcode; // 주제 코드
	private String tid; // 선생님 아이디
	private String sucode; // 과목 코드
	private String thname; // 주제 이름
	private Date trdate;
}
