package com.xebia.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.xebia.contants.RetailStoreConstants;
import com.xebia.model.BillDetails;
import com.xebia.service.BillService;
import com.xebia.util.RetailStoreUtil;

@Component
public class BillSeviceImpl implements BillService{
	
	@Value("${employeeDiscount}")
    private String employeeDiscount;
	@Value("${affiliateDiscount}")
    private String affiliateDiscount;
	@Value("${exitCustFromTwoYrDisc}")
    private String exitCustFromTwoYrDisc;
	@Value("${hundredBillDiscount}")
    private String hundredBillDiscount;
	
	@Autowired RetailStoreUtil retailStoreUtil;

	@Override
	public Double getBill(int id) {
		
		BillDetails billDetails=RetailStoreUtil.getBillDetailsBasedOnId(id);
		Double netPayableAmount=billDetails.getGrossAmount();
		if(billDetails.getUserType().getValue().equalsIgnoreCase(RetailStoreConstants.USER_TYPE_EMPLOYEE)){
			netPayableAmount=retailStoreUtil.getNetPayableAmtAfterDiscount(billDetails.getGrossAmount(),employeeDiscount);
		}else if(billDetails.getUserType().getValue().equalsIgnoreCase(RetailStoreConstants.USER_TYPE_AFFILIATE)){
			netPayableAmount=retailStoreUtil.getNetPayableAmtAfterDiscount(billDetails.getGrossAmount(),affiliateDiscount);
		}else {
			if(billDetails.isExistingCustomer() && billDetails.getExistCustTimePeriod()>=2){
				netPayableAmount=retailStoreUtil.getNetPayableAmtAfterDiscount(billDetails.getGrossAmount(),affiliateDiscount);
			}else if(billDetails.getGrossAmount()>100){
				String discount=String.valueOf(((billDetails.getGrossAmount())/100)*(Double.valueOf(hundredBillDiscount)));
				netPayableAmount=retailStoreUtil.getNetPayableAmtAfterDiscount(billDetails.getGrossAmount(),discount);
			}
		}
		return netPayableAmount;
	}

	@Bean
	public RetailStoreUtil getBean() {
		return new RetailStoreUtil();
	}
}
