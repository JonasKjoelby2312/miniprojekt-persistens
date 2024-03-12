package model;

public class SaleOrderLine {
	private int quantity;
	private double unitPrice;
	private Product product;
	
	public SaleOrderLine(int quantity, double unitPrice, Product product) {
		super();
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.product = product;
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

	@Override
	public String toString() {
		return "SaleOrderLine [quantity=" + quantity + ", unitPrice=" + unitPrice + ", product=" + product + "]";
	}
}
