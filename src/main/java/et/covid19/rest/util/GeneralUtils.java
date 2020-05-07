package et.covid19.rest.util;

import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.commons.lang3.StringUtils;

import et.covid19.rest.dal.model.ConstantEnum;

public class GeneralUtils {

    private static final String ALLOWED_CHARS = "ABCDEFGHIJKLMNOPRSTUVWXYZ0123456789";
    
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
	
	// === generate random case code ===
	/**
	 * generate code based on first 2 letters of region + random string
	 * 
	 * @param region
	 * @return
	 */
	public static String generateRandomCode(String region) {
	    if(StringUtils.isBlank(region)) {
	        region = "ETH";
	    }
	    char[] charList = ALLOWED_CHARS.toCharArray();
	    Random random = new SecureRandom();
	    StringBuilder sb = new StringBuilder();
	    sb.append(region.substring(0, 2).toUpperCase()).append('-');
	    for(int i = 0; i < EthConstants.DEFAULT_CODE_LENGTH; i++) {
	        sb.append(charList[random.nextInt(ALLOWED_CHARS.length())]);
	    }
	    
	    return sb.toString();
	}
}
