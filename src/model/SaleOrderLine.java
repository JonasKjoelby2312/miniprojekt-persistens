package model;

public class SaleOrderLine {
	
	private int saleOrderLineID;
	private int quantity;
	private double unitPrice;
	private Product product;
	
	public SaleOrderLine(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		unitPrice = product.getLatestSalesPrice().getValue();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

	public int getSaleOrderLineID() {
		return saleOrderLineID;
	}

	public void setSaleOrderLineID(int saleOrderLineID) {
		this.saleOrderLineID = saleOrderLineID;
	}

	@Override
	public String toString() {
		return "SaleOrderLine [saleOrderLineID=" + saleOrderLineID + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + ", product=" + product + "]";
	}

	
}
