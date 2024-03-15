package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import model.Invoice;
import model.SaleOrder;

public class InvoiceDB implements InvoiceDAO{
	//Instancevariables of the class InvoiceDB
	private static final String INSERT_INVOICE_Q = "insert into invoice values(?, ?, ?, ?)";
	private PreparedStatement insertInvoicePS;
	
	//The InvoiceDB class' constructor, primarily initializes instancevariables
	public InvoiceDB() throws Exception {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			insertInvoicePS = con.prepareStatement(INSERT_INVOICE_Q);
		} catch (Exception e) {
			throw new Exception("Could not prepare statments");
		}
	}

	//Method that inserts an invoice in the database through a PreparedStatement
	@Override
	public void insertInvoice(SaleOrder so) throws Exception {
		for(Invoice i : so.getInvoices()) {
			insertInvoicePS.setInt(1, i.getInvoiceNo());
			insertInvoicePS.setDate(2, Date.valueOf(i.getPaymentDate()));
			insertInvoicePS.setDouble(3, i.getAmount());
			insertInvoicePS.setInt(4, so.getSaleOrderID());
			
			insertInvoicePS.executeUpdate();
		}
		
	}
	
}
