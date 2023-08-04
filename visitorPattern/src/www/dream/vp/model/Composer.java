package www.dream.vp.model;

import www.dream.vp.visitor.Visitor;

public abstract class Composer extends Element implements Comparable<Composer> {
	public abstract int getPriority();
	
	private Element left, right; 

	public Composer() {

	}
	
	public Composer(Element left, Element right) {
		this.left = left;
		this.right = right;
	}
	
	public Element getLeft() {
		return left;
	}

	public Element getRight() {
		return right;
	} 
	
    public void setLeft(Element left) {
		this.left = left;
	}

	public void setRight(Element right) {
		this.right = right;
	}

	@Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
