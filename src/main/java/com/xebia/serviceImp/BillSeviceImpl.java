package com.xebia.serviceImp;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.xebia.contants.RetailStoreConstants;
import com.xebia.decoratorImpl.AffiliateDiscount;
import com.xebia.decoratorImpl.EmployeeDiscount;
import com.xebia.decoratorImpl.ExistingCustomerDiscount;
import com.xebia.decoratorImpl.HundredBillDiscount;
import com.xebia.model.BillDetails;
import com.xebia.service.BillService;
import com.xebia.util.RetailStoreUtil;

@Component
public class BillSeviceImpl implements BillService{

	@Autowired 
	private RetailStoreUtil retailStoreUtil;

	/* For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
	as a discount).
	 */
	@Autowired
	private HundredBillDiscount hundredBillDiscount;
	
	@Override
	public BigDecimal getBill(int id) {

		//Fetching the dummy record
		BillDetails billDetails=retailStoreUtil.getBillDetailsBasedOnId(id);

		BigDecimal netPayableAmount=billDetails.getGrossAmount();
		
		// Initially discounted price is same as original price
		BigDecimal discountPrice =netPayableAmount;
		
		

		// Discount for employee usertype
		if(billDetails.getUserType().getValue().equalsIgnoreCase(RetailStoreConstants.USER_TYPE_EMPLOYEE)){

			EmployeeDiscount employeeDiscount=new EmployeeDiscount(hundredBillDiscount);
			discountPrice=employeeDiscount.apply(netPayableAmount);
		}
		// Discount for affiliate usertype
		else if(billDetails.getUserType().getValue().equalsIgnoreCase(RetailStoreConstants.USER_TYPE_AFFILIATE)){

			AffiliateDiscount affiliateDiscount=new AffiliateDiscount(hundredBillDiscount);
			discountPrice=affiliateDiscount.apply(netPayableAmount);
		}
		// Discount for other usertype
		else {

			// Discount for other existing customer for more then two years
			if(billDetails.isExistingCustomer() && billDetails.getExistCustTimePeriod()>=2){

				ExistingCustomerDiscount existingCustDis=new ExistingCustomerDiscount(hundredBillDiscount);
				discountPrice=existingCustDis.apply(netPayableAmount);
			}
		}
		return discountPrice;
	}

	@Bean
	public RetailStoreUtil getRetailStoreUtilBean() {
		return new RetailStoreUtil();
	}
	
	@Bean
	public HundredBillDiscount getHundredBillDiscountBean() {
		return new HundredBillDiscount();
	}
}
