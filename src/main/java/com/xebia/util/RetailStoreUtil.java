package com.xebia.util;

import java.math.BigDecimal;
import java.util.Date;
import com.xebia.model.BillDetails;
import com.xebia.model.UserType;

public class RetailStoreUtil {


	// Creates dummy object of bill

	public  BillDetails getBillDetailsBasedOnId(int id){
		BillDetails billDetails=new BillDetails();
		// setting the BillDetails object
		billDetails.setBillDate(new Date());
		billDetails.setExistCustTimePeriod(1.5);
		billDetails.setExistingCustomer(false);
		billDetails.setGrossAmount(new BigDecimal(298));
		billDetails.setUserType(UserType.EMPLOYEE);
		return billDetails;
	}
}
