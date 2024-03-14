package db;

import java.util.List;

import model.SalesPrice;

public interface SalesPriceDAO {
	List<SalesPrice> findSalesPriceByID(int id) throws Exception;
}
