package model;

import java.util.ArrayList;
import java.util.List;

public class Location {
	private int locationID;
	private String locationtype;
	private List<Stock> stocks;

	public Location(int locationID, String locationtype, List<Stock> stocks) {
		super();
		this.locationID = locationID;
		this.locationtype = locationtype;
		this.stocks = stocks;
	}

	public String getLocationtype() {
		return locationtype;
	}

	public void locationtype(String locationtype) {
		this.locationtype = locationtype;
	}
	
	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	
	public List<Stock> getStocks() {
		return new ArrayList<>(stocks);
	}
	
	public void addStock(Stock stock) {
		if(stock != null) {
			stocks.add(stock);
		}
	}

	@Override
	public String toString() {
		return "Location [locationID=" + locationID + ", locationtype=" + locationtype + ", stocks=" + stocks + "]";
	}
}
