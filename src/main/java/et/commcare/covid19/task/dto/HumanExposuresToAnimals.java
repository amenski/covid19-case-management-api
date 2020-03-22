package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class HumanExposuresToAnimals {
	private ExposedByProducts exposedByProducts;
	private ExposedToAnimalsInEnvironment exposedToAnimalsInEnvironment;
	private HandledAnimals handledAnimals;
	private VisitLiveAnimalMarket visitLiveAnimalMarket;

	@JsonProperty("exposed_by_products")
	public ExposedByProducts getExposedByProducts() {
		return exposedByProducts;
	}

	@JsonProperty("exposed_by_products")
	public void setExposedByProducts(ExposedByProducts value) {
		this.exposedByProducts = value;
	}

	@JsonProperty("exposed_to_animals_in_environment")
	public ExposedToAnimalsInEnvironment getExposedToAnimalsInEnvironment() {
		return exposedToAnimalsInEnvironment;
	}

	@JsonProperty("exposed_to_animals_in_environment")
	public void setExposedToAnimalsInEnvironment(ExposedToAnimalsInEnvironment value) {
		this.exposedToAnimalsInEnvironment = value;
	}

	@JsonProperty("handled_animals")
	public HandledAnimals getHandledAnimals() {
		return handledAnimals;
	}

	@JsonProperty("handled_animals")
	public void setHandledAnimals(HandledAnimals value) {
		this.handledAnimals = value;
	}

	@JsonProperty("visit_live_animal_market")
	public VisitLiveAnimalMarket getVisitLiveAnimalMarket() {
		return visitLiveAnimalMarket;
	}

	@JsonProperty("visit_live_animal_market")
	public void setVisitLiveAnimalMarket(VisitLiveAnimalMarket value) {
		this.visitLiveAnimalMarket = value;
	}
}
