package www.dream.bbs.board.framework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Entity { // 자식 클래스에서 반드시 오버라이딩 해야만 사용할 수 있는 메소드
	/** DDL : idfunc.sql 에서의 id 길이에 맞추는 것  */
	public static final int ID_LENGTH = 4;
	
	// primitive type의 경우 기본값, reference type의 경우 null
	private String id; // 외부에서 사용불가, null값이 정의됨.

	@Override
	public String toString() {
		return "id=" + id;
	}
	
}
