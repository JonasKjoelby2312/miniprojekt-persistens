package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Club;
import model.Customer;

public class CustomerDB implements CustomerDAO {

	private static final String FIND_ALL_Q = "select customer_id, name, email, address, cvr, zipcode, phone_no from customer";
	private static final String FIND_BY_ID_Q = FIND_ALL_Q + " where customer_id = ?";
	private static final String UPDATE_Q = "update customers set name = ?, email = ?, address = ?, cvr = ?, zipcode = ?, phone_no = ? where customer_id = ?";
	private PreparedStatement findAllPS;
	private PreparedStatement findByIDPS;

	public CustomerDB() throws Exception {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findAllPS = con.prepareStatement(FIND_ALL_Q);
			findByIDPS = con.prepareStatement(FIND_BY_ID_Q);

		} catch (SQLException e) {
			throw new Exception("Cannot prepare query at the moment", e);
		}
	}

	@Override
	public List<Customer> findAllCustomers() throws Exception {
		List<Customer> res = new ArrayList<>();
		try {
			ResultSet rs = findAllPS.executeQuery();
			res = buildObjects(rs);
		} catch (SQLException e) {
			throw new Exception("Could not find customers", e);
		}
		return res;
	}
	
	@Override
	public Customer findCustomerByID(int id) throws Exception {
		Customer res = null;
		try {
			findByIDPS.setInt(1, id);
			ResultSet rs = findByIDPS.executeQuery();
			res = buildObject(rs);
		} catch (SQLException e) {
			throw new Exception("Could not find by ID", e);
		}
		return res;
	}

	private List<Customer> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<Customer> res = new ArrayList<>();
		Customer c = buildObject(rs);
		while (c != null) {
			res.add(c);
			c = buildObject(rs);
		}
		return res;
	}

	private Customer buildObject(ResultSet rs) throws SQLException {
		Customer c = null;
		if (rs.next()) {
			if (rs.getString("cvr") == null) {
				c = new Customer(
						rs.getInt("customer_id"),
						rs.getString("name"), 
						rs.getString("address"), 
						rs.getInt("zipcode"),
						rs.getString("phone_no"), 
						rs.getString("email"));
			} else {
				// Spørgsmål ift club og hvordan vi bruger subklassen
				c = new Club(
						rs.getInt("customer_id"),
						rs.getString("name"), 
						rs.getString("address"), 
						rs.getInt("zipcode"),
						rs.getString("phone_no"), 
						rs.getString("email"),
						rs.getString("cvr")
						);
			}
		}

		return c;
	}
	}
