package com.xebia.decoratorImpl;


import java.math.BigDecimal;
import com.xebia.decorator.Discount;
 
/*
 * Handle discount related to Affiliate userType
 */
public class AffiliateDiscount extends DiscountDecorator {
 

	public static final BigDecimal TEN = new BigDecimal(10);
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
 
    public AffiliateDiscount(Discount discount) {
        super(discount);
    }
 
    @Override
    public BigDecimal apply(BigDecimal originalPrice) {
        return super.apply(originalPrice).multiply(ONE_HUNDRED.subtract(TEN)).divide(ONE_HUNDRED);
    }
 
}