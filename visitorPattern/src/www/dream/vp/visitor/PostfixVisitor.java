package www.dream.vp.visitor;

import www.dream.vp.model.Composer;
import www.dream.vp.model.Operand;

/**
 * 왼, 오, 나
 */
public class PostfixVisitor extends Visitor {
	@Override
	public void visit(Composer composer) {
		composer.getLeft().accept(this);
		composer.getRight().accept(this);
		super.recordHistory(composer.whoAreYou());
	}

	@Override
	public void visit(Operand operand) {
		super.recordHistory(operand.whoAreYou());
	}
}
