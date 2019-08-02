package com.xebia.decoratorImpl;

import java.math.BigDecimal;
import com.xebia.decorator.Discount;
 
/*
 * Discount decorator.
 */
public class DiscountDecorator implements Discount {
 
    protected Discount discount;
 
    public DiscountDecorator(Discount discount) {
        this.discount = discount;
    }
 
    @Override
    public BigDecimal apply(BigDecimal originalPrice) {
        return discount.apply(originalPrice);
    }
}