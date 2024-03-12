package model;

public enum PriceType {
	SALESPRICE("SalesPrice"),
	PURCHASEPRICE("PurchasePrice");
	
	public final String label;
	
	private PriceType(String label) {
		this.label = label;
	}
}
