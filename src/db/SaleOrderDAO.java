package db;

import java.util.List;

import model.SaleOrder;

public interface SaleOrderDAO {
	
	List<SaleOrder> findAllSaleOrders() throws Exception;
	SaleOrder findSaleOrderByID(int id) throws Exception;
	//void updateSaleOrder(SaleOrder so) throws Exception;
	boolean insertSaleOrder(SaleOrder so) throws Exception;
	

}
