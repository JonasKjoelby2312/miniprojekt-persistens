package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.DeliveryStatus;
import model.SaleOrder;
import model.SaleOrderLine;

public class SaleOrderDB implements SaleOrderDAO {
	//Instancevariables of the class SaleOrderDB
	private static final String FIND_ALL_Q = "select sale_order_id, date, amount, delivery_status, delivery_date, freight, c_id, e_id from sale_order";
	private static final String FIND_SALE_ORDER_BY_ID_Q = FIND_ALL_Q + " where sale_order_id = ?";
	private static final String INSERT_SALE_ORDER_Q = "insert into sale_order (date, amount, delivery_status, delivery_date, freight, c_id, e_id) values (?, ?, ?, ?, ?, ?, ?)";
	
	private PreparedStatement findAllPS;
	private PreparedStatement findSaleOrderByIDPS;
	private PreparedStatement insertSaleOrderPS;
	
	private CustomerDB customerDB;
	private EmployeeDB employeeDB;
	private SaleOrderLineDB saleOrderLineDB;
	
	//The InvoiceDB class' constructor, primarily initializes instancevariables
	public SaleOrderDB() throws Exception {
		Connection con = DBConnection.getInstance().getConnection();
		customerDB = new CustomerDB();
		employeeDB = new EmployeeDB();
		saleOrderLineDB = new SaleOrderLineDB();
		
		try {
			findAllPS = con.prepareStatement(FIND_ALL_Q);
			findSaleOrderByIDPS = con.prepareStatement(FIND_SALE_ORDER_BY_ID_Q);
			insertSaleOrderPS = con.prepareStatement(INSERT_SALE_ORDER_Q, Statement.RETURN_GENERATED_KEYS);
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
		findSaleOrderByIDPS.setInt(1, id);
		try {
			ResultSet rs = findSaleOrderByIDPS.executeQuery();
			res = buildObject(rs);
		} catch (Exception e) {
			throw new Exception("Could not find SaleOrder by ID: " + id, e);
		}
		return res;
	}

	//Method that inserts a SaleOrder in the database through a PreparedStatement
	@Override
	public void insertSaleOrder(SaleOrder so) throws Exception {
		try {
			insertSaleOrderPS.setDate(1, Date.valueOf(so.getDate()));
			insertSaleOrderPS.setDouble(2, so.getAmount());
			insertSaleOrderPS.setString(3, so.getDeliveryStatus().toString());
			insertSaleOrderPS.setDate(4, Date.valueOf(so.getDeliveryDate()));
			insertSaleOrderPS.setDouble(5, so.getFreight()); 
			insertSaleOrderPS.setInt(6,so.getCustomer().getCustomerID()); 
			insertSaleOrderPS.setInt(7,so.getEmployee().getEmployeeID());
			
			
			int id = DBConnection.getInstance().executeInsertWithIdentity(insertSaleOrderPS);
			so.setSaleOrderID(id);
            	
		} catch (Exception e) {
			throw new Exception("Could not insert SaleOrder in DB");
		}
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
				
				res.setSaleOrderID(rs.getInt("sale_order_id"));
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
