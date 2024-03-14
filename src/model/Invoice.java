package model;

import java.time.LocalDate;

public class Invoice {
	
	private int invoiceID;
	private int invoiceNo;
	private LocalDate paymentDate;
	private double amount;
	public Invoice(int invoiceNo, LocalDate paymentDate, double amount) {
		super();
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	public int getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	public int getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	@Override
	public String toString() {
		return "Invoice [invoiceID=" + invoiceID + ", invoiceNo=" + invoiceNo + ", paymentDate=" + paymentDate
				+ ", amount=" + amount + "]";
	}
	
	
}
