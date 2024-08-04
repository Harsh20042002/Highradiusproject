package com.highradius.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

/**
 * Servlet implementation class AddData
 */
@WebServlet("/AddData")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setStatus(HttpServletResponse.SC_OK);
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        // Check if the request is a preflight request
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
		
		Invoice obj= new Invoice();
		
		try {
			long slNo = Long.parseLong(request.getParameter("slNo"));
			obj.setSlNo(slNo);
			
            long customerOrderID = Long.parseLong(request.getParameter("customerOrderID"));
            obj.setCustomerOrderID(customerOrderID);
            
            long salesOrg = Long.parseLong(request.getParameter("salesOrg"));
            obj.setSalesOrg(salesOrg);
            
            String distributionChannel = request.getParameter("distributionChannel");
            obj.setDistributionChannel(distributionChannel);
            
            String division = request.getParameter("division");
            obj.setDivision(division);
            
            float releasedCreditValue = Float.parseFloat(request.getParameter("releasedCreditValue"));
            obj.setReleasedCreditValue(releasedCreditValue);
            
            String purchaseOrderType = request.getParameter("purchaseOrderType");
            obj.setPurchaseOrderType(purchaseOrderType);
            
            long companyCode = Long.parseLong(request.getParameter("companyCode"));
            obj.setCompanyCode(companyCode);
            
            String orderCreationDate = request.getParameter("orderCreationDate");
            obj.setOrderCreationDate(orderCreationDate);
            
            String orderCreationTime = request.getParameter("orderCreationTime");
            obj.setOrderCreationTime(orderCreationTime);
            
            String creditControlArea = request.getParameter("creditControlArea");
            obj.setCreditControlArea(creditControlArea);
            
            long soldToParty = Long.parseLong(request.getParameter("soldToParty"));
            obj.setSoldToParty(soldToParty);
            
            float orderAmount = Float.parseFloat(request.getParameter("orderAmount"));
            obj.setOrderAmount(orderAmount);
            
            String requestedDeliveryDate = request.getParameter("requestedDeliveryDate");
            obj.setRequestedDeliveryDate(requestedDeliveryDate);
            
            String orderCurrency = request.getParameter("orderCurrency");
            obj.setOrderCurrency(orderCurrency);
            
            String creditStatus = request.getParameter("creditStatus");
            obj.setCreditStatus(creditStatus);
            
            long customerNumber = Long.parseLong(request.getParameter("customerNumber"));
            obj.setCustomerNumber(customerNumber);
            
            float amountInUsd = Float.parseFloat(request.getParameter("amountInUsd"));
            obj.setAmountInUsd(amountInUsd);
            
            long uniqueCustNumber = Long.parseLong(request.getParameter("uniqueCustNumber"));
            obj.setUniqueCustNumber(uniqueCustNumber);
		    
    		InvoiceDaoImpl invoice = new InvoiceDaoImpl(); 
    		response.getWriter().append(invoice.insertInvoice(obj));
            
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
