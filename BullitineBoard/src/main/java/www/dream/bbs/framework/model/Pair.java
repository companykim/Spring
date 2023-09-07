package www.dream.bbs.framework.model;

public class Pair<F, S> {
	/**
	 * Type이 달라도 정보 쌍을 담을 수 있는 그릇 같은 존재
	 * @param <F>
	 * @param <S>
	 */
	private F firstVal;
	private S secondVal;
	
	public Pair(F firstVal, S secondVal) {
		this.firstVal = firstVal;
		this.secondVal = secondVal;
	}

	public F getFirstVal() {
		return firstVal;
	}

	public S getSecondVal() {
		return secondVal;
	}
}
