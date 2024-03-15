package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.SaleOrder;
import model.SaleOrderLine;

public class SaleOrderLineDB implements SaleOrderLineDAO {
	//Instancevariables of the class SaleOrderLine
	private static final String FIND_ALL_Q = "select sale_order_line_id, quantity, unit_price, p_id, so_id from sale_order_line";
	private static final String FIND_BY_SALEORDER_ID_Q = FIND_ALL_Q + " where so_id = ?";
	private static final String INSERT_SALE_ORDER_LINES_Q = "insert into sale_order_line values (?, ?, ?, ?)";
	private PreparedStatement findBySaleOrderIDPS;
	private PreparedStatement insertSaleOrderLinePS;
	
	private ProductDB productDB;
	
	//The InvoiceDB class' constructor, primarily initializes instancevariables
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
					rs.getInt("quantity")
					);
		}
		return res;
	}

	//Method that inserts a SaleOrderLine in the database through a PreparedStatement
	@Override
	public void insertSaleOrderLines(SaleOrder so) throws Exception {
		List<SaleOrderLine> saleOrderLines = so.getSaleOrderLines();
		try {
			Connection con = DBConnection.getInstance().getConnection();
			for(SaleOrderLine sol : saleOrderLines) {				
				insertSaleOrderLinePS = con.prepareStatement(INSERT_SALE_ORDER_LINES_Q);
				
				insertSaleOrderLinePS.setInt(1, sol.getQuantity());
				insertSaleOrderLinePS.setDouble(2, sol.getUnitPrice());
				insertSaleOrderLinePS.setInt(3, sol.getProduct().getProductID());
				insertSaleOrderLinePS.setInt(4, so.getSaleOrderID()); //SKAL LIGE TJEKKES IGENNEM MED ISTVAN
				
				insertSaleOrderLinePS.executeUpdate();
			}
			
		} catch (Exception e) {
			throw new Exception("Could not insert SaleOrderLines", e);
		}
	}
	
}
