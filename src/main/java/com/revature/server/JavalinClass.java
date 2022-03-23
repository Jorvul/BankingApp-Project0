package com.revature.server;

import io.javalin.Javalin;

public class JavalinClass {

	public static void main(String[] args) {
		Javalin app = Javalin.create().start(8008);

		app.get("/customers", HandlerController.getCustomers);
		
		app.post("/customer", HandlerController.createCustomer);
		
		app.get("/customer/{customer_id}", HandlerController.getCustomerbyId);
		
		app.put("/customer/{customer_id}", HandlerController.updateCustomer);
		
		app.delete("/customer/{customer_id}", HandlerController.deleteCustomer);
		
		app.get("/getWithdrawals/{n1}", HandlerController.withdrawFunds);
	}

}
