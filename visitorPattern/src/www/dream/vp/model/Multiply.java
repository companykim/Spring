package www.dream.vp.model;

public class Multiply extends Composer {
	public static final int priority = 1;
	private static final char displayChar = '*';
	
	public Multiply(Element left, Element right) {
		super(left, right);
	}
	
    public String whoAreYou() {
    	return Character.toString(displayChar);
    }
	
}
