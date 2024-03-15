package db;

import java.util.List;

import model.SalesPrice;

public interface SalesPriceDAO {
	List<SalesPrice> findSalesPricesByID(int id) throws Exception;
}
