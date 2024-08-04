package com.highradius.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.highradius.connection.DataConnector;
import  com.highradius.connection.DatabaseConnection;
import com.highradius.model.Invoice;

public class InvoiceDaoImpl implements InvoiceDao {
	public List<Invoice> getInvoice()
	{
		List<Invoice> listofinvoice = new ArrayList<Invoice>();
		DatabaseConnection con=new DatabaseConnection();
		listofinvoice=con.getinvoices();
		return listofinvoice;
	}
	public String insertInvoice(Invoice obj)
	{
		DatabaseConnection con=new DatabaseConnection();
		return con.addInvoice(obj);
	}
	public void updateInvoice(long id, Invoice invoice) {
	    try {
	        Connection conn = DataConnector.connect();
	        String sql = "UPDATE h2h_oap SET customer_order_id = ?, sales_org = ?, distribution_channel = ?, division = ?, released_credit_value = ?, purchase_order_type = ?, company_code = ?, order_creation_date = ?, order_creation_time = ?, credit_control_area = ?, sold_to_party = ?, order_amount = ?, requested_delivery_date = ?, order_currency = ?, credit_status = ?, customer_number = ?, amount_in_usd = ?, unique_cust_id = ? WHERE sl_no = ?";

	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setLong(1, invoice.getCustomerOrderID());
	        statement.setLong(2, invoice.getSalesOrg());
	        statement.setString(3, invoice.getDistributionChannel());
	        statement.setString(4, invoice.getDivision());
	        statement.setFloat(5, invoice.getReleasedCreditValue());
	        statement.setString(6, invoice.getPurchaseOrderType());
	        statement.setLong(7, invoice.getCompanyCode());
	        statement.setString(8, invoice.getOrderCreationDate());
	        statement.setString(9, invoice.getOrderCreationTime());
	        statement.setString(10, invoice.getCreditControlArea());
	        statement.setLong(11, invoice.getSoldToParty());
	        statement.setFloat(12, invoice.getOrderAmount());
	        statement.setString(13, invoice.getRequestedDeliveryDate());
	        statement.setString(14, invoice.getOrderCurrency());
	        statement.setString(15, invoice.getCreditStatus());
	        statement.setLong(16, invoice.getCustomerNumber());
	        statement.setFloat(17, invoice.getAmountInUsd());
	        statement.setLong(18, invoice.getUniqueCustNumber());
	        statement.setLong(19, invoice.getSlNo());

	        statement.executeUpdate();
	        conn.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void deleteInvoice(long id) {
		// TODO Auto-generated method stub
		try {
	        Connection conn = DataConnector.connect();
	        String sql = "DELETE from h2h_oap WHERE SL_NO = ?";

	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setLong(1, id);
	        
	        statement.executeUpdate();
	        conn.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	    	
	        e.printStackTrace();
	    }
		
	}
}
