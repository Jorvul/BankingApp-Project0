package com.revature.server;

import io.javalin.http.Handler;

public class HandlerController {
	
	public static Handler depositFunds = ctx ->{
		int num1 = Integer.parseInt(ctx.pathParam("n1"));
		double balance = 30000.00;
		double total = balance + num1;
		ctx.result("You deposited a total " + num1 + " and your new balance is " + total);
	};

}
