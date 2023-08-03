package www.dream.vp.test;

import www.dream.vp.builder.ExpBuilder;
import www.dream.vp.factory.VisitorFactory;
import www.dream.vp.model.Element;
import www.dream.vp.visitor.Visitor;

public class Main2 {

	public static void main(String[] args) {
		//3 + 5 * 7
		Element top = ExpBuilder.build("344+5*7777");
		
	}

}
