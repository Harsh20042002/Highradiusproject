package com.highradius.servlets;

import java.util.ArrayList;
import java.util.List;

import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

public class DataLoadingServlet {
	
	public static List<Invoice> listofinvoice = new ArrayList<Invoice>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InvoiceDaoImpl invoice = new InvoiceDaoImpl(); 
		listofinvoice = invoice.getInvoice();
		
		if(listofinvoice != null)
		{
			System.out.println("This Run Perfectly "+ listofinvoice.size());
			System.out.println(listofinvoice.isEmpty());
		}
		

	}
	public List<Invoice> getInvoice()
	{
		
		return listofinvoice;
	}
}