package com.revature.server;

import com.revature.bank.daos.BankDAO;
import com.revature.bank.daos.BankPostgresDAO;

import io.javalin.Javalin;

public class JavalinClass {

	public static void main(String[] args) {
		Javalin app = Javalin.create().start(8008);
		BankDAO dao = new BankPostgresDAO();
		HandlerController hc = new HandlerController(dao);


		app.get("/customers", hc.getCustomers);
		
		app.post("/customer", hc.createCustomer);
		
		app.get("/customer/{customer_id}", hc.getCustomerById);
		
		app.put("/customer/{customer_id}", hc.updateCustomerById);
		
		app.delete("/customer/{customer_id}", hc.deleteCustomer);
		
		app.post("/customer/{customer_id}/{account_type}", hc.createAccountById);
		
		app.get("/customer/{customer_id}/{account_type}", hc.getAccountForCustomerById);
	}

}
