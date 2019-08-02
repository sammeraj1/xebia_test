package com.xebia.decoratorImpl;

import java.math.BigDecimal;
import com.xebia.decorator.Discount;
 
/*
 * Handle discount related to existing customer
 */
public class ExistingCustomerDiscount extends DiscountDecorator {
 
	public static final BigDecimal FIVE = new BigDecimal(5);
	public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
 
    public ExistingCustomerDiscount(Discount discount) {
        super(discount);
    }
 
    @Override
    public BigDecimal apply(BigDecimal originalPrice) {
        return super.apply(originalPrice).multiply(ONE_HUNDRED.subtract(FIVE)).divide(ONE_HUNDRED);
    }
 
}