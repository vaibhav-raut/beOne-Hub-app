package udaan.beone.mrpoint.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BDUtil {
	
	public static BigDecimal add(BigDecimal a, BigDecimal b) {
		if(a == null) {
			a = DataUtil.ZERO_BIG_DECIMAL;
		}
		if(b == null) {
			b = DataUtil.ZERO_BIG_DECIMAL;
		}
		
		return a.add(b);
	}	

	public static BigDecimal add(BigDecimal a, int b) {
		if(a == null) {
			a = DataUtil.ZERO_BIG_DECIMAL;
		}
		
		return a.add(new BigDecimal(b));
	}	

	public static BigDecimal sub(BigDecimal a, BigDecimal b) {
		if(a == null) {
			a = DataUtil.ZERO_BIG_DECIMAL;
		}
		if(b == null) {
			b = DataUtil.ZERO_BIG_DECIMAL;
		}
		
		return a.subtract(b);
	}	

	public static BigDecimal sub(BigDecimal a, int b) {
		if(a == null) {
			a = DataUtil.ZERO_BIG_DECIMAL;
		}
		
		return a.subtract(new BigDecimal(b));
	}	

	public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
		if(a == null) {
			return DataUtil.ZERO_BIG_DECIMAL;
		}
		if(b == null) {
			return DataUtil.ZERO_BIG_DECIMAL;
		}
		
		return a.multiply(b);
	}	

	public static BigDecimal multiply(BigDecimal a, float b) {
		if(a == null) {
			return DataUtil.ZERO_BIG_DECIMAL;
		}
		
		return a.multiply(new BigDecimal(b));
	}	

	public static BigDecimal divide(BigDecimal a, BigDecimal b) {
		if(a == null) {
			return DataUtil.ZERO_BIG_DECIMAL;
		}
		if(b == null || b.compareTo(DataUtil.ZERO_BIG_DECIMAL) == 0) {
			return DataUtil.ZERO_BIG_DECIMAL;
		}
		
		return a.divideToIntegralValue(b);
	}	

	public static BigDecimal divide(BigDecimal a, int b) {
		if(a == null) {
			return DataUtil.ZERO_BIG_DECIMAL;
		}
		if(b == 0) {
			return DataUtil.ZERO_BIG_DECIMAL;
		}
		
		return a.divideToIntegralValue(new BigDecimal(b));
	}
	
	private static final DecimalFormat f1 = new DecimalFormat("###.##");
	private static final DecimalFormat f2 = new DecimalFormat("000.##");
	private static final DecimalFormat f3 = new DecimalFormat(",##");
	
	public static String format(BigDecimal value) {
		if(value.intValue() >= 0) {
			if(value.intValue() < 1000) {
				return f1.format(value);
			} else {
				double hundreds = value.doubleValue() % 1000;
				int other = (int) (value.intValue() / 1000);
				return f3.format(other) + ',' + f2.format(hundreds);
			}
		} else {
			BigDecimal posValue = value.abs();
			if(posValue.intValue() < 1000) {
				return '-' + f1.format(posValue);
			} else {
				double hundreds = posValue.doubleValue() % 1000;
				int other = (int) (posValue.intValue() / 1000);
				return '-' + f3.format(other) + ',' + f2.format(hundreds);
			}
		}
	}
}
