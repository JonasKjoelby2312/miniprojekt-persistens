package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.SalesPrice;

public class SalesPriceDB implements SalesPriceDAO {
	private static final String FIND_ALL_Q = "select price_id, start_date, p_value, p_id from SalesPrice";
	private static final String FIND_ALL_BY_ID = FIND_ALL_Q + " where p_id = ?";
	
	private PreparedStatement findAllSalesPricesByID;
	
	public SalesPriceDB() throws Exception {
		Connection con = DBConnection.getInstance().getConnection();
		
		findAllSalesPricesByID = con.prepareStatement(FIND_ALL_BY_ID);
	}

	@Override
	public List<SalesPrice> findSalesPriceByID(int id) throws Exception {
		List<SalesPrice> res = new ArrayList<>();
		findAllSalesPricesByID.setInt(1, id);
		ResultSet rs = findAllSalesPricesByID.executeQuery();
		res = buildObjects(rs);
		return res;
	}

	private List<SalesPrice> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<SalesPrice> res = new ArrayList<>();
		SalesPrice sp = buildObject(rs);
		while (sp != null) {
			res.add(sp);
			sp = buildObject(rs);
		}
		return res;
	}

	private SalesPrice buildObject(ResultSet rs) throws SQLException {
		SalesPrice res = null;
		if(rs.next()) {
			res = new SalesPrice(
					rs.getInt("price_id"),
					rs.getDate("start_date").toLocalDate(),
					rs.getDouble("p_value")
					);
		}
		return res;
	}

}
