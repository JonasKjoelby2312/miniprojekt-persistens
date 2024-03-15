package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.SaleOrderController;
import model.SaleOrder;


class TestSaleOrderController {
	private SaleOrderController soc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		soc = new SaleOrderController();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRegisterSaleOrder(int customerID, int employeeID) {
		SaleOrder res = soc.;
		
	}

}
