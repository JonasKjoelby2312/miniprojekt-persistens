package model;

import java.util.List;

public class GunReplica extends Product {
	private String calbire;
	private String material;
	private double rentPrice;
	
	public GunReplica(int productID, String name, double purchasePrice, List<SalesPrice> salesPrices,
			String countryOfOrigin, Supplier supplier, List<Stock> stocks, String calbire, String material,
			double rentPrice) {
		super(productID, name, purchasePrice, salesPrices, countryOfOrigin, supplier, stocks);
		this.calbire = calbire;
		this.material = material;
		this.rentPrice = rentPrice;
	}

	public String getCalbire() {
		return calbire;
	}

	public void setCalbire(String calbire) {
		this.calbire = calbire;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	@Override
	public String toString() {
		return "GunReplica [calbire=" + calbire + ", material=" + material + ", rentPrice=" + rentPrice + "]";
	}

}
