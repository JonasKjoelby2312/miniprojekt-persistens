package model;

public class Address {

		private String zipcode;
		private String city;
		
		public Address(String zipcode, String city) {
			this.zipcode = zipcode;
			this.city = city;
		}


		public String getZipcode() {
			return zipcode;
		}

		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
		@Override
		public String toString() {
			return "Address [zipcode=" + zipcode + ", city=" + city + "]";
		}
}
