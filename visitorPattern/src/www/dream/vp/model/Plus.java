package www.dream.vp.model;

public class Plus extends Composer {
	public static final int priority = 2;
	private static final char displayChar = '+';
	
	public Plus() {
	}
	
	public Plus(Element left, Element right) {
		super(left, right);
	}
	
    public String whoAreYou() {
    	return Character.toString(displayChar);
    }
    
    public int getPriority() {
    	return priority;
    }
	
    @Override
    public int compareTo(Composer o) {
    	if (o == null) return 1;
    	return o == null ? 1 : o.getPriority() - priority;
    }
}
