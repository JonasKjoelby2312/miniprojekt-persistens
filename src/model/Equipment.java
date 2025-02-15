package model;

import java.util.List;

public class Equipment extends Product {
	private String type;
	private String description;

	public Equipment(int productID, String name, double purchasePrice, List<SalesPrice> salesPrices,
			String countryOfOrigin, Supplier supplier, List<Stock> stocks, String type, String description) {
		super(productID, name, purchasePrice, salesPrices, countryOfOrigin, supplier, stocks);
		this.type = type;
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Equipment [type=" + type + ", description=" + description + "]";
	}

}
