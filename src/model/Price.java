package model;

import java.time.LocalDate;

public class Price {
	private LocalDate startDate;
	private double value;
	
	public Price(LocalDate startDate, double value) {
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
		return "Price [startDate=" + startDate + ", value=" + value + "]";
	}
}
