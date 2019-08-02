package com.xebia.decoratorImpl;

import java.math.BigDecimal;
import com.xebia.decorator.Discount;
 
/*
 * Handle discount related to Employee userType
 */
public class EmployeeDiscount extends DiscountDecorator {
 
	public static final BigDecimal THIRTY = new BigDecimal(30);
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
 
    public EmployeeDiscount(Discount discount) {
        super(discount);
    }
 
    @Override
    public BigDecimal apply(BigDecimal originalPrice) {
        return super.apply(originalPrice).multiply(ONE_HUNDRED.subtract(THIRTY)).divide(ONE_HUNDRED);
    }
 
}