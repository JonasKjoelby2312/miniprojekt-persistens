package db;

import model.SaleOrder;

public interface InvoiceDAO {
	void insertInvoice(SaleOrder so) throws Exception;
}
