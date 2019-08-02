package com.xebia.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/*
 * Model class for BillDetails
 */

public class BillDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9096318135125352776L;

	/*
	 * Id of the generated bill
	 */
	private Integer id;
	/**
	 * Total amount before discount
	 */
	private BigDecimal grossAmount;

	/*
	 * Date of generation of bill
	 */
	private Date billDate;

	/*
	 * Variable to identify the type of users
	 */
	private UserType userType;

	/**
	 * Variable to identify whether user is existing customer or not
	 */
	private boolean isExistingCustomer;

	/*
	 * Time period since when customer is an existing customer
	 */
	private Double existCustTimePeriod;

	/*
	 * Getter for Id
	 */
	public Integer getId() {
		return id;
	}
	
	/*
	 * Setter for Id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/*
	 * Getter for grossAmount
	 */
	public BigDecimal getGrossAmount() {
		return grossAmount;
	}
	
	/*
	 * Setter for grossAmount
	 */
	public void setGrossAmount(BigDecimal grossAmount) {
		this.grossAmount = grossAmount;
	}
	
	/*
	 * Getter for billDate
	 */
	public Date getBillDate() {
		return billDate;
	}
	
	/*
	 * Setter for billDate
	 */
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	
	/*
	 * Getter for userType
	 */
	public UserType getUserType() {
		return userType;
	}
	
	/*
	 * Setter for userType
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	/*
	 * Getter for isExistingCustomer
	 */
	public boolean isExistingCustomer() {
		return isExistingCustomer;
	}
	
	/*
	 * Setter for isExistingCustomer
	 */
	public void setExistingCustomer(boolean isExistingCustomer) {
		this.isExistingCustomer = isExistingCustomer;
	}
	
	/*
	 * Getter for existCustTimePeriod
	 */
	public Double getExistCustTimePeriod() {
		return existCustTimePeriod;
	}
	
	/*
	 * Setter for existCustTimePeriod
	 */
	public void setExistCustTimePeriod(double d) {
		this.existCustTimePeriod = d;
	}

}
