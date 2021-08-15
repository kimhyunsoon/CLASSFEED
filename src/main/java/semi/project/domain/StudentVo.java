package semi.project.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVo { // 학생 정보
	private String sid; // 학생 아이디
	private String sname; // 학생 이름
	private String sphonenumber; // 학생 전화번호
	private String spwd; // 학생 비밀번호
	private String semail; // 학생 이메일
	private int sok; // 승인 여부
	private Date srdate; // 학생 가입날짜
}
