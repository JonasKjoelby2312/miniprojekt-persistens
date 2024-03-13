package model;

import java.time.LocalDate;

public class SalesPrice {
	private LocalDate startDate;
	private double value;
	
	public SalesPrice(LocalDate startDate, double value) {
		super();
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

	@Override
	public String toString() {
		return "SalesPrice [startDate=" + startDate + ", value=" + value + "]";
	}
	
	
}
