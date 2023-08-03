package www.dream.cdp.abstractFactory;

import java.util.Optional;

import www.dream.cdp.model.Car;
import www.dream.cdp.model.Insu;
import www.dream.cdp.model.SleepingPlace;
import www.dream.cdp.model.VINsu;

public class AF4M extends AF {
	@Override
	public Optional<SleepingPlace> createSP() {
		return Optional.of(new Car());
	}
	
	@Override
	public Optional<Insu> createInsu() {
		return Optional.of(new VINsu());
	}
}
