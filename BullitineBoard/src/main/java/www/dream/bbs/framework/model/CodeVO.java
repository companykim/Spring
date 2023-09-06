package www.dream.bbs.framework.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import www.dream.bbs.framework.model.Entity;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CodeVO {
	private String codeType; 
	private String codeVal; 
	private String validationRe;  //총 게시물 개수

}
