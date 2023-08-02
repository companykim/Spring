package www.dream.bb.serivce;

import jakarta.servlet.http.HttpServletRequest;

public class SCalc {
	public static int calc(HttpServletRequest req) {
		int operandFirst = Integer.parseInt(req.getParameter("operandFirst"));
		String operator = req.getParameter("operator");
		int operandSecond = Integer.parseInt(req.getParameter("operandSecond"));

		int ret = 0;
		switch (operator) {
		case "+": ret = operandFirst + operandSecond;  
			break;
		case "-": ret = operandFirst - operandSecond; 
			break;
		case "*": ret = operandFirst * operandSecond; 
			break;
		case "/": 
			ret =operandSecond == 0 ? Integer.MAX_VALUE : operandFirst / operandSecond; 
			break;
		}
		return ret;
	}
}
