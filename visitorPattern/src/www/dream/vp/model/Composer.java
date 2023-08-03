package www.dream.vp.model;

import www.dream.vp.visitor.Visitor;

public class Composer extends Element {
	private char displayChar;
	private Element left, right; 

	public Composer(char displayChar, Element left, Element right) {
		this.displayChar = displayChar;
		this.left = left;
		this.right = right;
	}
    
    public String whoAreYou() {
    	return Character.toString(displayChar);
    }
    
	public Element getLeft() {
		return left;
	}

	public Element getRight() {
		return right;
	} 
	
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
