package www.dream.vp.visitor;

import www.dream.vp.model.Composer;
import www.dream.vp.model.Operand;
/**
 * Strategy pattern
 */
public abstract class Visitor {
	private StringBuilder sb = new StringBuilder();
	 
	public void visit(Composer composer) { 
	}
	
	public void visit(Operand operand) { 
	}
	
	public String getHistory() {
		 return sb.toString();
	}
	
	protected void recordHistory(String hist) {
		sb.append(hist);
	}
}
