package www.dream.vp.builder;

import www.dream.vp.model.Element;

public class ExpBuilder {
	
	public static Element build(String exp) {
		// 344+5*7777
		String[] eles = exp.split("\\+|\\*| ");
		// tokenize 344, 5, 7
		for (String e : eles) {
			if (exp.length() == e.length())
				break;
			String op = exp.substring(e.length(), e.length() + 1);
			exp = exp.substring(e.length() + 1);
			System.out.println(op);
		}
		return null;
	}
	
}
