package model;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private int productID;
	private String name;
	private double purchasePrice;
	private List<SalesPrice> salesPrices;
	private String countryOfOrigin;
	private Supplier supplier;
	private List<Stock> stocks;

	public Product(int productID, String name, double purchasePrice, List<SalesPrice> salesPrices, String countryOfOrigin, Supplier supplier, List<Stock> stocks) {
		super(); 
		this.productID = productID;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.countryOfOrigin = countryOfOrigin;
		this.supplier = supplier;
		this.salesPrices = salesPrices;
		this.stocks = stocks;
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
	
	public List<Stock> getStocks() {
		return new ArrayList<>(stocks);
	}
	
	public boolean addStock(Stock stock) {
		boolean res = false;
		if(stock != null) {
			stocks.add(stock);
			res = true;
		}
		return res;
	}
	
	public boolean removeStock(Stock stock) {
		boolean res = false;
		if(stock != null) {
			stocks.remove(stock);
			res = true;
		}
		return res;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", purchasePrice=" + purchasePrice
				+ ", salesPrices=" + salesPrices + ", countryOfOrigin=" + countryOfOrigin + ", supplier=" + supplier
				+ ", stocks=" + stocks + "]";
	}
}

	
