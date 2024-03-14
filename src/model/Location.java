package model;

public class Location {
	private int locationID;
	private String locationtype;
	
	public Location(String locationtype) {
		this.locationtype = locationtype;
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

	@Override
	public String toString() {
		return "Location [locationID=" + locationID + ", locationtype=" + locationtype + "]";
	}
}
