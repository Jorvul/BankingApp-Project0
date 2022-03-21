package com.revature.server;

import io.javalin.Javalin;

public class JavalinClass {

	public static void main(String[] args) {
		Javalin app = Javalin.create().start(8008);

		app.get("/getAllCustomers", HandlerController.getCustomers);
		
		app.post("/newClient", HandlerController.createCustomer);
		
		app.get("/getWithdrawals/{n1}", HandlerController.withdrawFunds);
	}

}
