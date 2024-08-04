package com.highradius.connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.highradius.model.Invoice;


public class FetchData {
	
	private List<Invoice> listofinvoice = new ArrayList<Invoice>();

	public List<Invoice> getdata()
	{
		try 
		{
			Connection conn = DataConnector.connect();
			// TODO Auto-generated method stub
	        Statement stmt = conn.createStatement();
	        String query = "SELECT * FROM h2h_oap limit 24";
	        ResultSet rs = stmt.executeQuery(query);
	        
	        
	        while (rs.next()) 
	        {
	        	Invoice obj= new Invoice();
	        	
	        	long SiNo = rs.getLong("Sl_no");
	        	obj.setSlNo(SiNo);
	        	
	            long customerOrderID = rs.getLong("CUSTOMER_ORDER_ID");
	            obj.setCustomerOrderID(customerOrderID);
	        	
	            long salesOrg= rs.getLong("SALES_ORG");
	        	obj.setSalesOrg(salesOrg);
	        	
	        	String distributionChannel= rs.getString("DISTRIBUTION_CHANNEL");
	        	obj.setDistributionChannel(distributionChannel);
	        	
	        	String division= rs.getString("DIVISION");
	        	obj.setDivision(division);
	        	
	        	float releasedCreditValue= rs.getFloat("RELEASED_CREDIT_VALUE");
	        	obj.setReleasedCreditValue(releasedCreditValue);
	        	
	        	String purchaseOrderType= rs.getString("PURCHASE_ORDER_TYPE");
	        	obj.setPurchaseOrderType(purchaseOrderType);
	            
	        	long  companyCode= rs.getLong("COMPANY_CODE");
	            obj.setCompanyCode(companyCode);
	            
	            String orderCreationDate= rs.getString("ORDER_CREATION_DATE");
	            obj.setOrderCreationDate(orderCreationDate);
	            
	            String orderCreationTime= rs.getString("ORDER_CREATION_TIME");
	            obj.setOrderCreationTime(orderCreationTime);
	            
	            String creditControlArea= rs.getString("CREDIT_CONTROL_AREA");
	            obj.setCreditControlArea(creditControlArea);
	            
	            long soldToParty= rs.getLong("SOLD_TO_PARTY");
	            obj.setSoldToParty(soldToParty);
	            
	            float orderAmount= rs.getFloat("ORDER_AMOUNT");
	            obj.setOrderAmount(orderAmount);
	            
	            String requestedDeliveryDate= rs.getString("REQUESTED_DELIVERY_DATE");
	            obj.setRequestedDeliveryDate(requestedDeliveryDate);
	            
	            String orderCurrency= rs.getString("ORDER_CURRENCY");
	            obj.setOrderCurrency(orderCurrency);
	            
	            String creditStatus= rs.getString("CREDIT_STATUS");
	            obj.setCreditStatus(creditStatus);
	            
	            long customerNumber= rs.getLong("CUSTOMER_NUMBER");
	            obj.setCustomerNumber(customerNumber);
	            
	            float amountInUsd = rs.getFloat("AMOUNT_IN_USD");
	            obj.setAmountInUsd(amountInUsd);
	            
	            long uniqueCustNumber= rs.getLong("UNIQUE_CUST_ID");
	            obj.setUniqueCustNumber(uniqueCustNumber);
	           
	            listofinvoice.add(obj);
	        }
	        conn.close();

		}
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		return listofinvoice;
	}

}