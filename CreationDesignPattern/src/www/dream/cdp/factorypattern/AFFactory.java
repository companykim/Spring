package www.dream.cdp.factorypattern;

import www.dream.cdp.abstractFactory.AF;
import www.dream.cdp.abstractFactory.AF4F;
import www.dream.cdp.abstractFactory.AF4M;

public class AFFactory {
	public static AF createAF(String type) {
		switch (type) {
		case "M" :
			return new AF4M();
		case "F" :
			return new AF4F();
		}
		return null;
	}
}
