package et.covid19.rest.util;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

import et.covid19.rest.dal.model.ConstantEnum;

public class GeneralUtils {

	public static ConstantEnum defaultIfNull(Consumer<ConstantEnum> consumer, Supplier<ConstantEnum> supplier, Integer defaultValue) {
		if(Objects.isNull(supplier.get())) {
			ConstantEnum en = new ConstantEnum();
			en.setEnumCode(defaultValue);
			consumer.accept(en);
			return en;
		}
		return supplier.get();
	}
	
	
	private  GeneralUtils() {
		throw new IllegalStateException("Utility class.");
	}
}
