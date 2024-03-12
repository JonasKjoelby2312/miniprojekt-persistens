package model;

public enum DeliveryStatus {
	DELIVERED("Delivered"),
	ONGOING("Ongoing"),
	CANCELLED("Cancelled");
	
	public final String label;
	
	private DeliveryStatus(String label) {
		this.label = label;
	}
}
