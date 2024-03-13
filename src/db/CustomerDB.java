package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDB implements CustomerDAO {

	private static final String FIND_ALL_Q = "select id, name, email, address, cvr, zipcode, phone_no  from customer";
	private static final String FIND_BY_PHONE_Q = FIND_ALL_Q + " where phone_no = ?";
	// HJÆLP AF ISTVAN ift where phone skal kodes og skrives i eclipse
	private static final String UPDATE_Q = "update customers set name = ?, email = ?, address = ?, cvr = ?, zipcode = ?, phone_no = ? where phone_no = ?";
	private PreparedStatement findAllPS;
	private PreparedStatement findByPhonePS;
	private PreparedStatement updatePS;

	public CustomerDB() throws Exception {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findAllPS = con.prepareStatement(FIND_ALL_Q);
			findByPhonePS = con.prepareStatement(FIND_BY_PHONE_Q);
			updatePS = con.prepareStatement(UPDATE_Q);

		} catch (SQLException e) {
			throw new Exception("Cannot prepare query at the moment", e);
		}
	}

	@Override
	public List<Customer> findAllCustomers() throws Exception {
		List<Customer> res = new ArrayList<>();
		try {
			ResultSet rs = findAllPS.executeQuery();
			res = buildObjects(rs, false);
		} catch (SQLException e) {
			throw new Exception("Could not find customers", e);
		}
		return res;
	}

	private List<Customer> buildObjects(ResultSet rs, boolean fullAssociation) throws SQLException {
		ArrayList<Customer> res = new ArrayList<>();
		Customer c = buildObject(rs, false);
		while (c != null) {
			res.add(c);
			c = buildObject(rs, false);
		}
		return res;
	}

	

	@Override
	public Customer findByPhone(String phone) throws Exception {
		Customer res = null;
		try {
			findByPhonePS.setString(1, phone);
			ResultSet rs = findByPhonePS.executeQuery();
			res = buildObject(rs, false);
		} catch (SQLException e) {
			throw new Exception("Could not find by phone", e);
		}

		return res;
	}

	private Customer buildObject(ResultSet rs, boolean fullAssociation) throws SQLException {
		Customer c = null;
		if (rs.next()) {
			if (rs.getString("cvr") == null) {
				c = new Customer(
						rs.getString("name"), 
						rs.getString("address"), 
						rs.getInt("zipcode"),
						rs.getString("city"), 
						rs.getString("phone_no"), 
						rs.getString("email"));
			} else {
				// Spørgsmål ift club og hvordan vi bruger subklassen
			}
		}

		return c;
	}

	@Override
	public void updateCustomer(Customer c) throws Exception {
		
		try {
			updatePS.setString(1, c.getName());
			updatePS.setString(2, c.getAddress());
			updatePS.setInt(3, c.getZipcode());
			updatePS.setString(4, c.getCity());
			updatePS.setString(5, c.getPhoneNo());
			updatePS.setString(6, c.getEmail());
			updatePS.executeUpdate();
			
		} catch (SQLException e) {
			throw new Exception("Could not update customer", e);
		}
		
		

	}

	}
