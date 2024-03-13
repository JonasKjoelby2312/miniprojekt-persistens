package model;

public class Clothing extends Product {
	private String size;
	private String color;

	public Clothing(String name, double purchasePrice, SalesPrice salesPrice, String countryOfOrigin,
			Supplier supplier, Stock stock, String size, String color) {
		super(name, purchasePrice, salesPrice, countryOfOrigin, supplier, stock);
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