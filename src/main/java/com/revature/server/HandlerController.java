package com.revature.server;

import java.util.ArrayList;

import io.javalin.http.Handler;

public class HandlerController {
	
	public static Handler getClients = ctx ->{
		ArrayList<String> customer = new ArrayList<String>();
		customer.add("Jorge");
		customer.add("Travis");
		customer.add("Elena");
		customer.add("Wilfred");
	ctx.result("Total clients in this account are " + customer);
		
	};
	
	public static Handler withdrawFunds = ctx -> {
		int num = Integer.parseInt(ctx.pathParam("n1"));
		double balance = 30000.00;
		double total = balance - num;
		ctx.result("You withdrew a total " + num + " and your new balance is " + total);
	};

}
