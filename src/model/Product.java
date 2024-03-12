package model;

public class Product {

	private String name;
	private Price purchasePrice;
	private Price salesPrice;
	private String countryOfOrigin;
	private int minStock;
	private int maxStock;
	private int currentStock;
	private String location;
	private Supplier supplier;

	public void product(String name, Price purchasePrice, Price salesPrice, String countryOfOrigin, int minStock,
			int maxStock, int currentStock, String location, Supplier supplier) {
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.maxStock = maxStock;
		this.currentStock = currentStock;
		this.location = location;
		this.supplier = supplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Price getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Price purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Price getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Price salesPrice) {
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

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", purchasePrice=" + purchasePrice + ", salesPrice=" + salesPrice
				+ ", countryOfOrigin=" + countryOfOrigin + ", minStock=" + minStock + ", maxStock=" + maxStock
				+ ", currentStock=" + currentStock + ", location=" + location + ", supplier=" + supplier + "]";
	}
}
