package model;

public class GunReplica extends Product {
	private String calbire;
	private String material;
	private double rentPrice;

	public GunReplica(String name, Price purchasePrice, Price salesPrice, String countryOfOrigin, int minStock,
			int maxStock, int currentStock, String location, Supplier supplier, String calibre, String material,
			double rentPrice) {
		super(name, purchasePrice, salesPrice, countryOfOrigin, minStock, maxStock, currentStock, location, supplier);
		this.calbire = calibre;
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
