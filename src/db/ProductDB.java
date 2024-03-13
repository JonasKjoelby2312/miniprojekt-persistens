
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDB implements ProductDAO {

	private static final String FIND_ALL_Q = "select id, name, purchasePrice, salesPrice, countryOfOrgin, minStock, maxStock, currentStock, location, supplier from Product";
	private static final String FIND_BY_ID_Q = FIND_ALL_Q + " where product_id = ?";
	// HJÆLP AF ISTVAN ift where phone skal kodes og skrives i eclipse
	//private static final String UPDATE_Q = "update products set name = ?, purchasePrice = ?, salesPrice = ?, countryOfOrgin = ?, minStock = ?, maxStock = ?, currentStock = ?, location = ?, supplier = ?, where product_id = ?";
	private PreparedStatement findAllPS;
	private PreparedStatement findByIDPS;
	//private PreparedStatement updatePS;

	public ProductDB() throws Exception {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findAllPS = con.prepareStatement(FIND_ALL_Q);
			findByIDPS = con.prepareStatement(FIND_BY_ID_Q);
			//updatePS = con.prepareStatement(UPDATE_Q);

		} catch (SQLException e) {
			throw new Exception("Cannot prepare query at the moment", e);
		}
	}

	@Override
	public List<Product> findAllProducts() throws Exception {
		List<Product> res = new ArrayList<>();
		try {
			ResultSet rs = findAllPS.executeQuery();
			res = buildObjects(rs);
		} catch (SQLException e) {
			throw new Exception("Could not find customers", e);
		}
		return res;
	}

	private List<Product> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<Product> res = new ArrayList<>();
		Product p = buildObject(rs);
		while (p != null) {
			res.add(p);
			p = buildObject(rs);
		}
		return res;
	}

	

	@Override
	public Product findProductByID(int id, boolean fullAssociation) throws Exception {
		Product res = null;
		try {
			findByIDPS.setInt(1, id);
			ResultSet rs = findByIDPS.executeQuery();
			res = buildObject(rs);
		} catch (SQLException e) {
			throw new Exception("Could not find by ID", e);
		}

		return res;
	}
	

	private Product buildObject(ResultSet rs) throws SQLException {
		Product p = new Product (			
						rs.getString("name"),
						rs.getDouble("purchasePrice"), 
						rs.getDouble("salesPrice"), 
						rs.getString("countryOfOrgin"),
						rs.getString("supplier"), 
						rs.getInt("stock")); 
		return p;
	}

//	@Override
//	public void updateProduct(Product p) throws Exception {
//		
//		try {
//			updatePS.setString(1, p.getName());
//			updatePS.setDouble(2, p.getPurchasePrice());
//			updatePS.setSalesPrice(3, p.getSalesPrice());
//			updatePS.setString(4, p.getCountryOfOrigin());
//			updatePS.setSupplier(5, p.getSupplier());
//			updatePS.setStock(6, p.getStock());
//			updatePS.executeUpdate();
//			
//		} catch (SQLException e) {
//			throw new Exception("Could not update product", e);
//		}
		
	}

	
