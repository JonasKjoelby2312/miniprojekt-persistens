package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.SaleOrderLine;

public class SaleOrderLineDB implements SaleOrderLineDAO {
	private static final String FIND_ALL_Q = "select sale_order_line_id, quantity, unitprice, p_id, so_id from SaleOrderLine";
	private static final String FIND_BY_SALEORDER_ID_Q = FIND_ALL_Q + " where so_id = ?";
	private PreparedStatement findBySaleOrderIDPS;
	
	private ProductDB productDB;
	
	public SaleOrderLineDB() throws Exception {
		Connection con = DBConnection.getInstance().getConnection();
		productDB = new ProductDB();
		
		try {
			findBySaleOrderIDPS = con.prepareStatement(FIND_BY_SALEORDER_ID_Q);
		} catch (Exception e) {
			throw new Exception("Could not prepare statements");
		}
	}
	
	@Override
	public List<SaleOrderLine> findBySaleOrderID(int id) throws Exception {
		List<SaleOrderLine> res = new ArrayList<>();
		findBySaleOrderIDPS.setInt(1, id);
		ResultSet rs = findBySaleOrderIDPS.executeQuery();
		res = buildObjects(rs);
		return res;
	}

	private List<SaleOrderLine> buildObjects(ResultSet rs) throws Exception {
		List<SaleOrderLine> res = new ArrayList<>();
		SaleOrderLine sol = buildObject(rs);
		while(sol != null) {
			res.add(sol);
			sol = buildObject(rs);
		}
		return res;
	}

	private SaleOrderLine buildObject(ResultSet rs) throws Exception {
		SaleOrderLine res = null;
		if(rs.next()) {
			res = new SaleOrderLine(
					productDB.findProductByID(rs.getInt("p_id"), false),
					//rs.getInt("sale_order_line_id"),
					rs.getInt("quantity")
					//rs.getDouble("unitprice"),
					);
		}
		return res;
	}
	
}
