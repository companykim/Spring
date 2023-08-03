package www.dream.cdp.factorypattern;

import java.util.Optional;

import www.dream.cdp.model.FInsu;
import www.dream.cdp.model.Insu;
import www.dream.cdp.model.VINsu;

public class InsuFactory {
	/** Factory Pattern */
	public static Optional<Insu> createInsu(String InsuType) {
		
		switch (InsuType) {
		case "Car" :
			return Optional.of(new VINsu());
		case "Bus" :
			return Optional.of(new FInsu());
		}
		return Optional.empty();
	}
}
