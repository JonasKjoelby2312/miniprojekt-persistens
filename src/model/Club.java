package model;

public class Club extends Customer {
	private String cvr;

	public Club(String name, String address, int zipcode, String city, String phoneNo, String email) {
		super(name, address, zipcode, city, phoneNo, email);
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
