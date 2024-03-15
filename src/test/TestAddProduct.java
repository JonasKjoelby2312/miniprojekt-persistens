package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.CustomerController;
import controller.EmployeeController;
import controller.SaleOrderController;
import model.SaleOrder;

class TestAddProduct {
	
	private SaleOrderController soc;
	private EmployeeController ec;
	private CustomerController cc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		soc = new SaleOrderController();
		ec = new EmployeeController();
		cc = new CustomerController();
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddProduct() throws Exception {
		SaleOrder res = soc.registerOrder(1, 1);
		assertNotNull(res);
		
		assertSame(0, res.getSaleOrderLines().size());
		soc.addProduct(1, 2);
		assertSame(1, res.getSaleOrderLines().size());
		
	}

}
