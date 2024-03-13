package model;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private String name;
	private double purchasePrice;
	private List<SalesPrice> salesPrices;
	private String countryOfOrigin;
	private Supplier supplier;
	private Stock stock;

	public Product(String name, double purchasePrice, SalesPrice salesPrice, String countryOfOrigin, Supplier supplier, Stock stock) {
		super(); 
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.countryOfOrigin = countryOfOrigin;
		this.supplier = supplier;
		this.stock = stock; 
		salesPrices = new ArrayList<SalesPrice>();
		addSalesPrice(salesPrice);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public List<SalesPrice> getSalesPrices() {
		return new ArrayList<>(salesPrices);
	}
	
	public SalesPrice getLatestSalesPrice() {
		return salesPrices.get(salesPrices.size() - 1);
	}

	public boolean addSalesPrice(SalesPrice price) {
		boolean res = false;
		if(price != null) {
			salesPrices.add(price);
			res = true;
		}
		return res;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", purchasePrice=" + purchasePrice + ", countryOfOrigin=" + countryOfOrigin
				+ ", supplier=" + supplier + "]";
	}

	
}

	
