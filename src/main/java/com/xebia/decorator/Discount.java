package com.xebia.decorator;

import java.math.BigDecimal;

/*
 * Discount interface to specify the discount action.
 */
public interface Discount {
     
    BigDecimal apply(BigDecimal originalPrice);
     
}