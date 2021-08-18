package semi.project.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherVo { // 선생님 정보
	private String tid; // 선생님 아이디
	private String tpwd; // 선생님 비밀번호
	private String tname; // 선생님 이름
	private String tphonenumber; // 선생님 전화번호
	private String temail; // 선생님 이메일
	private String tagency; // 선생님 기관명
	private Date trdate; // 선생님 가입날짜
}
