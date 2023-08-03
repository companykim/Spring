package www.dream.cdp.abstractFactory;

import java.util.Optional;

import www.dream.cdp.model.Insu;
import www.dream.cdp.model.SleepingPlace;

public abstract class AF {
	public abstract Optional<SleepingPlace> createSP();
	public abstract Optional<Insu> createInsu();
}
