package com.highradius.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.connection.DataConnector;
import com.highradius.model.Invoice;

@WebServlet("/PredictData")
public class PredictData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PredictData() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Invoice> listofinvoice = new ArrayList<Invoice>(); 
        try {
            Connection conn = DataConnector.connect();
            
            String query = "SELECT * FROM h2h_oap WHERE (CREDIT_STATUS != '') AND (STR_TO_DATE(ORDER_CREATION_DATE, '%d-%m-%Y') BETWEEN DATE_SUB(STR_TO_DATE(?, '%d-%m-%Y'), INTERVAL 5 DAY) AND STR_TO_DATE(?, '%d-%m-%Y'));";
            PreparedStatement statement = conn.prepareStatement(query);
            
            String orderCreationDate = request.getParameter("orderCreationDate");
            if (orderCreationDate != null) {
                statement.setString(1, orderCreationDate);
                statement.setString(2, orderCreationDate);
            }
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                Invoice obj = new Invoice();
                
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
                
                String orderCreationDateValue= rs.getString("ORDER_CREATION_DATE");
                obj.setOrderCreationDate(orderCreationDateValue);
                
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
        } catch(Exception e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        String jsonResponse = gson.toJson(listofinvoice);

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append(jsonResponse);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
