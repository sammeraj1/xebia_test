package com.xebia.decoratorImpl;

import java.math.BigDecimal;
import com.xebia.decorator.Discount;

/*
 * Handles discount related to bill more then 100
 */
public class HundredBillDiscount implements Discount {
 
	public static final Integer FIVE = new Integer(5);
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    @Override
    public BigDecimal apply(BigDecimal originalPrice) {

    	Integer discount=(originalPrice.divide(ONE_HUNDRED).intValue())*FIVE;
        return originalPrice.subtract(new BigDecimal(discount));
    }
 
}