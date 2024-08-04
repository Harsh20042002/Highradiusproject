package com.highradius.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.highradius.model.Invoice;

public class DatabaseConnection {
	private List<Invoice> listofinvoice = new ArrayList<Invoice>();

	public List<Invoice> getinvoices() {
		FetchData fetch=new FetchData();
		listofinvoice=fetch.getdata();
		return listofinvoice;
	}

	public void setListofinvoice(List<Invoice> listofinvoice) {
		this.listofinvoice = listofinvoice;
	}
	
	public String addInvoice(Invoice invoice) {
	    try {
	        Connection conn = DataConnector.connect();
	        String sql = "INSERT INTO h2h_oap (sl_no, customer_order_id, sales_org, distribution_channel, division, released_credit_value, purchase_order_type, company_code, order_creation_date, order_creation_time, credit_control_area, sold_to_party, order_amount, requested_delivery_date, order_currency, credit_status, customer_number, amount_in_usd, unique_cust_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setLong(1, invoice.getSlNo());
	        statement.setLong(2, invoice.getCustomerOrderID());
	        statement.setLong(3, invoice.getSalesOrg());
	        statement.setString(4, invoice.getDistributionChannel());
	        statement.setString(5, invoice.getDivision());
	        statement.setFloat(6, invoice.getReleasedCreditValue());
	        statement.setString(7, invoice.getPurchaseOrderType());
	        statement.setLong(8, invoice.getCompanyCode());
	        statement.setString(9, invoice.getOrderCreationDate());
	        statement.setString(10, invoice.getOrderCreationTime());
	        statement.setString(11, invoice.getCreditControlArea());
	        statement.setLong(12, invoice.getSoldToParty());
	        statement.setFloat(13, invoice.getOrderAmount());
	        statement.setString(14, invoice.getRequestedDeliveryDate());
	        statement.setString(15, invoice.getOrderCurrency());
	        statement.setString(16, invoice.getCreditStatus());
	        statement.setLong(17, invoice.getCustomerNumber());
	        statement.setFloat(18, invoice.getAmountInUsd());
	        statement.setLong(19, invoice.getUniqueCustNumber());

	        statement.executeUpdate();
	        conn.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        return e.getMessage();
	    } catch (SQLException e) {
	    	
	        e.printStackTrace();
	        return e.getMessage();
	    }
		return "Inserted Successfully!!";
	}

	
	
}