package com.highradius.implementation;

import java.util.List;

import com.highradius.model.Invoice;

public interface InvoiceDao {
	List<Invoice> getInvoice();
	String insertInvoice(Invoice obj);
	void updateInvoice(long id,Invoice obj);
	void deleteInvoice(long id);
}
