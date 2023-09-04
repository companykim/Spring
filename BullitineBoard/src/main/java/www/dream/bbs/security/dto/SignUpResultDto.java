package www.dream.bbs.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** 회원가입 결과 정보 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpResultDto {

	private boolean success;

	private int code;

	private String msg;

}