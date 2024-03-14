package db;

import java.sql.SQLException;
import java.util.List;

import model.SaleOrder;
import model.SaleOrderLine;

public interface SaleOrderLineDAO {
	List<SaleOrderLine> findBySaleOrderID(int id) throws Exception;
	void insertSaleOrderLines(SaleOrder so) throws Exception;
}
