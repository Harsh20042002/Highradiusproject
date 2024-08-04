package com.highradius.servlets;

import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

public class AddServlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void addInvoice(Invoice Obj)
	{
		InvoiceDaoImpl invoice = new InvoiceDaoImpl(); 
		invoice.insertInvoice(Obj);
	}
}