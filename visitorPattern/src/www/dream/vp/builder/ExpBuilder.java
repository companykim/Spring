package www.dream.vp.builder;

import java.util.Stack;

import www.dream.vp.model.Composer;
import www.dream.vp.model.Element;
import www.dream.vp.model.Multiply;
import www.dream.vp.model.Operand;
import www.dream.vp.model.Plus;

public class ExpBuilder {
	static char[] ops = new char[] {'+', '*'};
	
	public static Element build(String exp) {
		Stack<Composer>	연산자쌓기 = new Stack<>();
		//3+9+1*9*6    +4+5*7
		Stack<Element> 숫자또는결과쌓기 = new Stack<>();
		int expLength = exp.length();
		int 숫자시작점 = -1;
		for (int i = 0; i < expLength; i++) {    // 3, 4, 5
			// 3+9*5*6+4*7
			char iChar = exp.charAt(i); //*
			Composer operator = null;
			if ((operator = getOperator(iChar)) != null) {
				Operand num = new Operand(Integer.parseInt(exp.substring(숫자시작점, i)));
				숫자또는결과쌓기.push(num);
				숫자시작점 = -1;
				
				while (!연산자쌓기.isEmpty() && operator.compareTo(연산자쌓기.peek()) < 0) {
					buildOperator(연산자쌓기, 숫자또는결과쌓기);
				}
				연산자쌓기.push(operator);
			} else {
				if (숫자시작점 == -1) {
					숫자시작점 = i; //0, -1, 4, -1, 6
				}
			}
		}
		Operand num = new Operand(Integer.parseInt(exp.substring(숫자시작점, expLength)));
		숫자또는결과쌓기.push(num);
		
		while (! 연산자쌓기.isEmpty()) {
			buildOperator(연산자쌓기, 숫자또는결과쌓기);
		}
		return 숫자또는결과쌓기.pop();
	}

	private static void buildOperator(Stack<Composer> 연산자쌓기, Stack<Element> 숫자또는결과쌓기) {
		// operatorStack에서 Operator를 pop한 다음
		// 숫자또는결과쌓기에서 두 Element를 pop하여 붙여서
		// 결과물을 elementStack에 push한다
		Composer top = 연산자쌓기.pop();
		top.setRight(숫자또는결과쌓기.pop());
		top.setLeft(숫자또는결과쌓기.pop());
		숫자또는결과쌓기.push(top);
	}
	
	private static Composer getOperator(char iChar) {
		if (iChar == '+') 
			return new Plus();
		if (iChar == '*') 
			return new Multiply();
		return null;
	}
	
	private static boolean isOperator(char iChar) {
		for (char op : ops)
			if (op == iChar)
				return true;
		return false;
	}
}
