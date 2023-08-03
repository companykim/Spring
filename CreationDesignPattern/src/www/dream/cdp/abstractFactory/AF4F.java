package www.dream.cdp.abstractFactory;

import java.util.Optional;

import www.dream.cdp.model.FInsu;
import www.dream.cdp.model.House;
import www.dream.cdp.model.Insu;
import www.dream.cdp.model.SleepingPlace;

public class AF4F extends AF {
	@Override
	public Optional<SleepingPlace> createSP() {
		return Optional.of(new House());
	}
	
	@Override
	public Optional<Insu> createInsu() {
		return Optional.of(new FInsu());
	}
}
