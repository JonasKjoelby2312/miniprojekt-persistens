package model;

import java.time.LocalDate;

public class SalesPrice {
	
	private int salesID;
	private LocalDate startDate;
	private double value;
	
	public SalesPrice(int SalesID, LocalDate startDate, double value) {
		super();
		this.salesID = salesID;
		this.startDate = startDate;
		this.value = value;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	

	public int getSalesID() {
		return salesID;
	}

	public void setSalesID(int salesID) {
		this.salesID = salesID;
	}

	@Override
	public String toString() {
		return "SalesPrice [salesID=" + salesID + ", startDate=" + startDate + ", value=" + value + "]";
	}

	
	
	
}
