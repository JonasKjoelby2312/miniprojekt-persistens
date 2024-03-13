package model;

public class Location {
	
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

	@Override
	public String toString() {
		return "Location [locationtype=" + locationtype + "]";
	}

}
