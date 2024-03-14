package model;

import java.util.List;

public class Clothing extends Product {
	private String size;
	private String color;

	public Clothing(int productID, String name, double purchasePrice, List<SalesPrice> salesPrices,
			String countryOfOrigin, Supplier supplier, List<Stock> stocks, String size, String color) {
		super(productID, name, purchasePrice, salesPrices, countryOfOrigin, supplier, stocks);
		this.size = size;
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Clothing [size=" + size + ", color=" + color + "]";
	}

}