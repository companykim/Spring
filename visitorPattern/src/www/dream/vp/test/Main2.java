package www.dream.vp.test;

import www.dream.vp.builder.ExpBuilder;
import www.dream.vp.factory.VisitorFactory;
import www.dream.vp.model.Element;
import www.dream.vp.visitor.Visitor;

public class Main2 {

	public static void main(String[] args) {
		Element top = ExpBuilder.build("3+9*5*6+4*7");
		Visitor visitor = VisitorFactory.createVisitor("PrefixVisitor");
		top.accept(visitor);
		System.out.println(visitor.getHistory());
	}
	
}
