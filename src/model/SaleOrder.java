package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaleOrder {
	private int orderNo;
	private LocalDate date;
	private Double amount;
	private DeliveryStatus deliveryStatus;
	private LocalDate deliveryDate;
	private double freight;
	private List<SaleOrderLine> saleOrderLines;
	private List<Invoice> invoices;
	
	public SaleOrder(LocalDate date, Double amount, DeliveryStatus deliveryStatus, LocalDate deliveryDate,
			double freight) {
		super();
		this.date = date;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.freight = freight;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}
	

	public List<SaleOrderLine> getSaleOrderLines() {
		return new ArrayList<>(saleOrderLines);
	}

	public void addSaleOrderLine(SaleOrderLine sol) {
		if(sol != null) {
			saleOrderLines.add(sol);
		}
	}
	
	public void removeSaleOrderLine(SaleOrderLine sol) {
		if(sol != null) {
			saleOrderLines.remove(sol);
		}
	}
	
	public List<Invoice> getInvoices() {
		return new ArrayList<>(invoices);
	}
	
	public void addInvoice(Invoice i) {
		if(i != null) {
			invoices.add(i);
		}
	}
	
	public void removeInvoice(Invoice i) {
		if(i != null) {
			invoices.remove(i);
		}
	}

	@Override
	public String toString() {
		return "SaleOrder [date=" + date + ", amount=" + amount + ", deliveryStatus=" + deliveryStatus
				+ ", deliveryDate=" + deliveryDate + ", freight=" + freight + ", saleOrderLines=" + saleOrderLines
				+ ", invoices=" + invoices + "]";
	}
}
