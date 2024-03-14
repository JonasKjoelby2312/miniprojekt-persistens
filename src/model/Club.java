package model;

public class Club extends Customer {
	private String cvr;

	public Club(int customerID, String name, String address, int zipcode, String city, String phoneNo, String email, String cvr) {
		super(customerID, name, address, zipcode, phoneNo, email);
		this.cvr = cvr;
	}

	public String getCvr() {
		return cvr;
	}

	public void setCvr(String cvr) {
		this.cvr = cvr;
	}

	@Override
	public String toString() {
		return "Club [cvr=" + cvr + "]";
	}

}
