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
 * Servlet implementation class EditData
 */
@WebServlet("/EditData")
public class EditData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditData() {
        super();
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        Invoice obj = new Invoice();

        try {
            String slNoStr = request.getParameter("slNo");
            if (slNoStr != null) {
                long slNo = Long.parseLong(slNoStr);
                obj.setSlNo(slNo);
            }

            String customerOrderIDStr = request.getParameter("customerOrderID");
            if (customerOrderIDStr != null) {
                long customerOrderID = Long.parseLong(customerOrderIDStr);
                obj.setCustomerOrderID(customerOrderID);
            }

            String salesOrgStr = request.getParameter("salesOrg");
            if (salesOrgStr != null) {
                long salesOrg = Long.parseLong(salesOrgStr);
                obj.setSalesOrg(salesOrg);
            }

            String distributionChannel = request.getParameter("distributionChannel");
            if (distributionChannel != null) {
                obj.setDistributionChannel(distributionChannel);
            }

            String division = request.getParameter("division");
            if (division != null) {
                obj.setDivision(division);
            }

            String releasedCreditValueStr = request.getParameter("releasedCreditValue");
            if (releasedCreditValueStr != null) {
                float releasedCreditValue = Float.parseFloat(releasedCreditValueStr);
                obj.setReleasedCreditValue(releasedCreditValue);
            }

            String purchaseOrderType = request.getParameter("purchaseOrderType");
            if (purchaseOrderType != null) {
                obj.setPurchaseOrderType(purchaseOrderType);
            }

            String companyCodeStr = request.getParameter("companyCode");
            if (companyCodeStr != null) {
                long companyCode = Long.parseLong(companyCodeStr);
                obj.setCompanyCode(companyCode);
            }

            String orderCreationDate = request.getParameter("orderCreationDate");
            if (orderCreationDate != null) {
                obj.setOrderCreationDate(orderCreationDate);
            }

            String orderCreationTime = request.getParameter("orderCreationTime");
            if (orderCreationTime != null) {
                obj.setOrderCreationTime(orderCreationTime);
            }

            String creditControlArea = request.getParameter("creditControlArea");
            if (creditControlArea != null) {
                obj.setCreditControlArea(creditControlArea);
            }

            String soldToPartyStr = request.getParameter("soldToParty");
            if (soldToPartyStr != null) {
                long soldToParty = Long.parseLong(soldToPartyStr);
                obj.setSoldToParty(soldToParty);
            }

            String orderAmountStr = request.getParameter("orderAmount");
            if (orderAmountStr != null) {
                float orderAmount = Float.parseFloat(orderAmountStr);
                obj.setOrderAmount(orderAmount);
            }

            String requestedDeliveryDate = request.getParameter("requestedDeliveryDate");
            if (requestedDeliveryDate != null) {
                obj.setRequestedDeliveryDate(requestedDeliveryDate);
            }

            String orderCurrency = request.getParameter("orderCurrency");
            if (orderCurrency != null) {
                obj.setOrderCurrency(orderCurrency);
            }

            String creditStatus = request.getParameter("creditStatus");
            if (creditStatus != null) {
                obj.setCreditStatus(creditStatus);
            }

            String customerNumberStr = request.getParameter("customerNumber");
            if (customerNumberStr != null) {
                long customerNumber = Long.parseLong(customerNumberStr);
                obj.setCustomerNumber(customerNumber);
            }

            String amountInUsdStr = request.getParameter("amountInUsd");
            if (amountInUsdStr != null) {
                float amountInUsd = Float.parseFloat(amountInUsdStr);
                obj.setAmountInUsd(amountInUsd);
            }

            String uniqueCustNumberStr = request.getParameter("uniqueCustNumber");
            if (uniqueCustNumberStr != null) {
                long uniqueCustNumber = Long.parseLong(uniqueCustNumberStr);
                obj.setUniqueCustNumber(uniqueCustNumber);
            }

            InvoiceDaoImpl invoice = new InvoiceDaoImpl();
            invoice.updateInvoice(obj.getSlNo(), obj);

            response.getWriter().append("Updated Successfully!!");

        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().append("Invalid number format: ").append(e.getMessage());
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().append("Error updating data: ").append(e.getMessage());
            e.printStackTrace();
        }
    }
}