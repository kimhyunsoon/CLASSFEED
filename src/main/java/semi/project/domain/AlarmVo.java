package semi.project.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlarmVo {
	private long aseq;
	private String atname;
	private String asuname;
	private String adivision;
	private String sid;
	private String sucode;
	private long bseq;
}
