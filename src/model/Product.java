package model;

public class Product {

	private String name;
	private price purchasePrice;
	private price salesPrice;
	private String countryOfOrigin;
	private int minStock;
	private int maxStock;
	private int currentStock;
	private String location;

	public void product(String name, price pruchasePrice, price salesPrice, String countryOfOrigin, int minStock,
			int maxStock, int currentStock, String location) {
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.maxStock = maxStock;
		this.currentStock = currentStock;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public price getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(price purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public price getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(price salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	public int getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}

	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", countryOfOrigin=" + countryOfOrigin + ", minStock=" + minStock
				+ ", maxStock=" + maxStock + ", currentStock=" + currentStock + ", location=" + location + "]";
	}

}
