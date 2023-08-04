package www.dream.vp.model;

public class Multiply extends Composer {
	public static final int priority = 1;
	private static final char displayChar = '*';
	
	public Multiply() {
	}
	
	public Multiply(Element left, Element right) {
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
