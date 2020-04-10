package et.covid19.rest.util;

import java.util.List;
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
	
	public static boolean validateNumericValues(List<Supplier<Integer>> suppliers) {
		if(Objects.isNull(suppliers) || suppliers.isEmpty() )
			return false;
		return suppliers.stream().allMatch(val -> (val.get() != null && Integer.signum(val.get()) != -1));
	}
	
	private  GeneralUtils() {
		throw new IllegalStateException("Utility class.");
	}
}
