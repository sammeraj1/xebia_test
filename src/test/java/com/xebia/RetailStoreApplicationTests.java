package com.xebia;


import junit.framework.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import com.xebia.decoratorImpl.HundredBillDiscount;
import com.xebia.service.BillService;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class RetailStoreApplicationTests {

	@Autowired 
	private BillService billService;

	@Mock
	private HundredBillDiscount hundredBillDiscount;

	@Test
	public void getBill() {
		when(hundredBillDiscount.apply(new BigDecimal(100))).thenReturn(new BigDecimal(95));
		Assert.assertEquals(201.6, billService.getBill(12345).doubleValue());
	}
}
