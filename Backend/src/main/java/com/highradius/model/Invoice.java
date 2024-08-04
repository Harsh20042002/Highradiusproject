package com.highradius.model;

public class Invoice {
	private long slNo;
	private long customerOrderID;
	private long salesOrg;
	private String distributionChannel;
	private String division;
	private float releasedCreditValue;
	private String purchaseOrderType;
	private long companyCode;
	private String orderCreationDate;
	private String orderCreationTime;
	private String creditControlArea;
	private long soldToParty;
	private float orderAmount;
	private String requestedDeliveryDate;
	private String orderCurrency;
	private String creditStatus;
	private long customerNumber;
	private float amountInUsd;
	private long uniqueCustNumber;

	public Invoice() {
		// TODO Auto-generated constructor stub
	}


	public long getSlNo() {
		return slNo;
	}

	public void setSlNo(long siNo) {
		this.slNo = siNo;
	}

	public long getCustomerOrderID() {
		return customerOrderID;
	}

	public void setCustomerOrderID(long customerOrderID) {
		this.customerOrderID = customerOrderID;
	}

	public String getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

	public long getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(long salesOrg) {
		this.salesOrg = salesOrg;
	}

	public float getReleasedCreditValue() {
		return releasedCreditValue;
	}

	public void setReleasedCreditValue(float releasedCreditValue) {
		this.releasedCreditValue = releasedCreditValue;
	}

	public String getPurchaseOrderType() {
		return purchaseOrderType;
	}

	public void setPurchaseOrderType(String purchaseOrderType) {
		this.purchaseOrderType = purchaseOrderType;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(long companyCode) {
		this.companyCode = companyCode;
	}

	public String getOrderCreationDate() {
		return orderCreationDate;
	}

	public void setOrderCreationDate(String orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}

	public String getOrderCreationTime() {
		return orderCreationTime;
	}

	public void setOrderCreationTime(String orderCreationTime) {
		this.orderCreationTime = orderCreationTime;
	}

	public long getSoldToParty() {
		return soldToParty;
	}

	public void setSoldToParty(long soldToParty) {
		this.soldToParty = soldToParty;
	}

	public String getCreditControlArea() {
		return creditControlArea;
	}

	public void setCreditControlArea(String creditControlArea) {
		this.creditControlArea = creditControlArea;
	}

	public float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getRequestedDeliveryDate() {
		return requestedDeliveryDate;
	}

	public void setRequestedDeliveryDate(String requestedDeliveryDate) {
		this.requestedDeliveryDate = requestedDeliveryDate;
	}

	public String getOrderCurrency() {
		return orderCurrency;
	}

	public void setOrderCurrency(String orderCurrency) {
		this.orderCurrency = orderCurrency;
	}

	public String getCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}

	public long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public float getAmountInUsd() {
		return amountInUsd;
	}

	public void setAmountInUsd(float amountInUsd) {
		this.amountInUsd = amountInUsd;
	}

	public long getUniqueCustNumber() {
		return uniqueCustNumber;
	}

	public void setUniqueCustNumber(long uniqueCustNumber) {
		this.uniqueCustNumber = uniqueCustNumber;
	}

}