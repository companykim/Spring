package www.dream.vp.visitor;

import www.dream.vp.model.Composer;
import www.dream.vp.model.Operand;

/**
 * 왼, 나, 오
 */
public class InfixVisitor extends Visitor {
	@Override
	public void visit(Composer composer) {
		composer.getLeft().accept(this);
		super.recordHistory(composer.whoAreYou());
		composer.getRight().accept(this);
	}

	@Override
	public void visit(Operand operand) {
		super.recordHistory(operand.whoAreYou());
	}
}
