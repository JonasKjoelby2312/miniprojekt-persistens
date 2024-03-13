package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SaleOrder;

public class SaleOrderDB implements SaleOrderDAO {
	private static final String FIND_ALL_Q = "select date, amount, delivery_status, delivery_status, freight, c_id, e_id, i_id, sol_id";
	private static final String FIND_SALE_ORDER_BY_NO_Q = FIND_ALL_Q + " where sale_order_id = ?";
	private static final String UPDATE_Q = "update sale_order set date = ?, amount = ?, delivery_status = ?, delivery_status = ?, freight = ?, c_id = ?, e_id = ?, i_id = ?, sol_id = ? ";
	private static final String INSERT_SALE_ORDER_Q = "?";
	
	private PreparedStatement findAllPS, findSaleOrderByIdPS, updatePS, insertSaleOrderPS;
	
	
	public SaleOrderDB() throws Exception {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findAllPS = con.prepareStatement(FIND_ALL_Q);
			findSaleOrderByIdPS = con.prepareStatement(FIND_ALL_Q);
			updatePS = con.prepareStatement(UPDATE_Q);
			insertSaleOrderPS = con.prepareStatement(INSERT_SALE_ORDER_Q);
		} catch (SQLException e) {
			
		}
		
	}
	@Override
	public List<SaleOrder> findAllSaleOrders() throws Exception {
		ResultSet rs;
		try {
			rs = findAllPS.executeQuery();
			List<SaleOrder> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			
		}
		
	}

	private List<SaleOrder> buildObjects(ResultSet rs) throws SQLException {
		List<SaleOrder> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildObject(rs));
		}
		return res;
	}
	private SaleOrder buildObject(ResultSet rs) {
		SaleOrder so = new SaleOrder(
				rs.getDate("date"),
				rs.getInt("amount"),
				switch(rs.getString("delivery_status"))
					
					
				
				rs.getDate("delivery_date").toLocalDate(),
				rs.getDouble("freight"));
		return null;
	}
	@Override
	public SaleOrder findSaleOrderById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSaleOrder(SaleOrder so) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insertSaleOrder(SaleOrder so) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
