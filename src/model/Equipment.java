package model;

public class Equipment extends Product {
	private String type;
	private String description;

	public Equipment(String name, double purchasePrice, SalesPrice salesPrice, String countryOfOrigin,
			Supplier supplier, Stock stock, String type, String description) {
		super(name, purchasePrice, salesPrice, countryOfOrigin, supplier, stock);
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
