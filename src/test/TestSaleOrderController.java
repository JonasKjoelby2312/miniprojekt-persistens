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


class TestSaleOrderController {
	private SaleOrderController soc;
	private CustomerController cc;
	private EmployeeController ec;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		soc = new SaleOrderController();
		cc = new CustomerController();
		ec = new EmployeeController();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRegisterSaleOrder() throws Exception {
		SaleOrder res = soc.registerOrder(1, 1);
		assertNotNull(res);
		assertEquals(res.getCustomer().getCustomerID(), 1);
		assertEquals(res.getEmployee().getEmployeeID(), 1);
		
	}

}
