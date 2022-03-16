package com.revature.server;

import io.javalin.Javalin;

public class JavalinClass {

	public static void main(String[] args) {
		Javalin app = Javalin.create().start(8008);

		app.get("/getAllClients", HandlerController.getClients);
		
		app.post("/newClient", HandlerController.createClient);
		
		app.get("/getWithdrawals/{n1}", HandlerController.withdrawFunds);
	}

}
