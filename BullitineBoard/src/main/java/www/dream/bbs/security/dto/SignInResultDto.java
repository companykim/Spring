package www.dream.bbs.security.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 예제 13.30
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignInResultDto extends SignUpResultDto {

	private String token;   // JWT
	private List<String> roles; 

	@Builder
	public SignInResultDto(boolean success, int code, 
			String msg, String token, List<String> roles) {
		super(success, code, msg );
		this.token = token;
		this.roles = roles;
	}

}