package model;

import java.time.LocalDate;

public class Price {
	private LocalDate startDate;
	private double value;
	private PriceType type;
	public Price(LocalDate startDate, double value, PriceType type) {
		super();
		this.startDate = startDate;
		this.value = value;
		this.type = type;
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
	public PriceType getType() {
		return type;
	}
	public void setType(PriceType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Price [startDate=" + startDate + ", value=" + value + ", type=" + type + "]";
	}
}
