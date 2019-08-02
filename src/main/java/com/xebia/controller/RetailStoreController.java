package com.xebia.controller;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xebia.service.BillService;


@RestController
public class RetailStoreController {


	@Autowired BillService billService;


	@RequestMapping(value="/getBill/{id}", method=RequestMethod.GET)
	public BigDecimal getBillDetails(@PathVariable("id") int id){
		BigDecimal billAmount=billService.getBill(id);
		return billAmount;
	}
}
