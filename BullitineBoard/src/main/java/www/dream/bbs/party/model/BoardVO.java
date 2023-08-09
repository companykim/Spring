package www.dream.bbs.party.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import www.dream.bbs.board.framework.model.Entity;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BoardVO extends Entity {
	private String name; 
	private String descrip; 
	private long postCnt = 0;  //총 게시물 개수

	/**
	 * 사용자로부터 정보가 만들어 질 때 사용
	 */
	public BoardVO(String name, String descrip) { 
		this.name = name;
		this.descrip = descrip;
	}

	@Override
	public String toString() { // 부모 클래스가 정의한 함수를 덮어씌워 다시 정의하여 사용하는 것
		return "BoardVO [" + super.toString() + ", name=" + name + ", descrip=" + descrip + ", postCnt=" + postCnt + "]/n";
	}

}
