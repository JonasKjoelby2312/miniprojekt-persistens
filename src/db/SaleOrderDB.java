package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DeliveryStatus;
import model.SaleOrder;
import model.SaleOrderLine;

public class SaleOrderDB implements SaleOrderDAO {
	private static final String FIND_ALL_Q = "select date, amount, delivery_status, delivery_date, freight, c_id, e_id, sol_id from sale_order";
	private static final String FIND_SALE_ORDER_BY_ID_Q = FIND_ALL_Q + " where sale_order_id = ?";
	//private static final String UPDATE_Q = "update sale_order set date = ?, amount = ?, delivery_status = ?, delivery_status = ?, freight = ?, c_id = ?, e_id = ?, i_id = ?, sol_id = ? ";
	private static final String INSERT_SALE_ORDER_Q = "insert into sale_order (date, amount, delivery_status, delivery_date, freight, c_id, e_id) values (?, ?, ?, ?, ?, ?, ?)";
	
	private PreparedStatement findAllPS, findSaleOrderByIdPS, updatePS, insertSaleOrderPS;
	
	private CustomerDB customerDB;
	private EmployeeDB employeeDB;
	private SaleOrderLineDB saleOrderLineDB;
	
	
	public SaleOrderDB() throws Exception {
		Connection con = DBConnection.getInstance().getConnection();
		customerDB = new CustomerDB();
		employeeDB = new EmployeeDB();
		saleOrderLineDB = new SaleOrderLineDB();
		
		try {
			findAllPS = con.prepareStatement(FIND_ALL_Q);
			findSaleOrderByIdPS = con.prepareStatement(FIND_ALL_Q);
			//updatePS = con.prepareStatement(UPDATE_Q);
			insertSaleOrderPS = con.prepareStatement(INSERT_SALE_ORDER_Q);
		} catch (SQLException e) {
			throw new Exception("Could not prepare statements");
		}
		
	}
	@Override
	public List<SaleOrder> findAllSaleOrders() throws Exception {
		List<SaleOrder> res = new ArrayList<>();
		try {
			ResultSet rs = findAllPS.executeQuery();
			res = buildObjects(rs);
		} catch (SQLException e) {
			throw new Exception("Could not find SaleOrders", e);
		}
		return res;
	}
	
	@Override
	public SaleOrder findSaleOrderByID(int id) throws Exception {
		SaleOrder res = null;
		findSaleOrderByIdPS.setInt(1, id);
		try {
			ResultSet rs = findSaleOrderByIdPS.executeQuery();
			res = buildObject(rs);
		} catch (Exception e) {
			throw new Exception("Could not find SaleOrder by ID: " + id, e);
		}
		return res;
	}

	//@Override
	//public void updateSaleOrder(SaleOrder so) throws Exception {
	//	// TODO Auto-generated method stub
	//	
	//}

	@Override
	public boolean insertSaleOrder(SaleOrder so) throws Exception {
		boolean res = false;
		try {
			
			  insertSaleOrderPS.setDate(1, Date.valueOf(so.getDate()));
			  insertSaleOrderPS.setDouble(2, so.getAmount());
			  insertSaleOrderPS.setString(3, so.getDeliveryStatus().toString());
			  insertSaleOrderPS.setDate(4, Date.valueOf(so.getDeliveryDate()));
			  insertSaleOrderPS.setDouble(5, so.getFreight()); 
			  insertSaleOrderPS.setInt(6,so.getCustomer().getCustomerID()); 
			  insertSaleOrderPS.setInt(7,so.getEmployee().getEmployeeID());
			
			
			
			 
			
			
//			insertSaleOrderPS.setDate(1, Date.valueOf(so.getDate()));
//			insertSaleOrderPS.setDouble(2, 200.0);
//			insertSaleOrderPS.setString(3, so.getDeliveryStatus().toString());
//			insertSaleOrderPS.setDate(4, Date.valueOf("2024-03-13"));
//			insertSaleOrderPS.setDouble(5, 45.0);
//			insertSaleOrderPS.setInt(6, 1);
//			insertSaleOrderPS.setInt(7, 1);
			
			
			insertSaleOrderPS.executeUpdate();
			res = true;
		} catch (Exception e) {
			throw new Exception("Could not insert SaleOrder in DB");
		}
		
		return res; //Skal den altid return true, også ingenting når den får fejl?
	}
	
	private List<SaleOrder> buildObjects(ResultSet rs) throws Exception {
		List<SaleOrder> res = new ArrayList<>();
		SaleOrder so = buildObject(rs);
		while(so != null) {
			res.add(so);
			so = buildObject(rs);
		}
		return res;
	}
	
	private SaleOrder buildObject(ResultSet rs) throws Exception{
		SaleOrder res = null;
		
		try {
			if(rs.next()) {
				res = new SaleOrder(
						employeeDB.findEmployeeByID(rs.getInt("e_id")),
						customerDB.findCustomerByID(rs.getInt("c_id"))
						);
				
				res.setDate(rs.getDate("date").toLocalDate());
				res.setAmount(rs.getDouble("amount"));
				res.setDeliveryStatus(DeliveryStatus.valueOf(rs.getString("delivery_status")));
				res.setDeliveryDate(rs.getDate("delivery_date").toLocalDate());
				res.setFreight(rs.getDouble("freight"));
				
				List<SaleOrderLine> sols = saleOrderLineDB.findBySaleOrderID(rs.getInt("sale_order_id"));
				for(SaleOrderLine sol : sols) {
					res.addSaleOrderLine(sol);
				}
			}
		} catch (Exception e) {
			throw new Exception("Could not build object", e);
		}
		return res;
	}
}
