package com.revature.server;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.revature.bank.Customer;
import com.revature.jdbc.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;


import io.javalin.http.Handler;

public class HandlerController {
	
	public static Handler getCustomers = ctx ->{
		ResultSet rs;
		PreparedStatement ptsmt;
		Connection conn = ConnectionUtils.createConnection();
		
		String selectCustomers = "select * from bank";
		ptsmt = conn.prepareStatement(selectCustomers);
		rs=ptsmt.executeQuery();
		ArrayList<Customer> customer = new ArrayList<Customer>();
		Customer c;
		while(rs.next()) {
			int id = rs.getInt("customer_id");
			String name = rs.getString("customer_name");
			int bal = rs.getInt("balance");
			c=new Customer(id,name, bal);
		}
		rs.close();
		ptsmt.close();
		ctx.json(customer);
	};
	
	public static Handler createClient = ctx ->{
		
	};
	
	public static Handler withdrawFunds = ctx -> {
		int num = Integer.parseInt(ctx.pathParam("n1"));
		double balance = 30000.00;
		double total = balance - num;
		ctx.result("You withdrew a total " + num + " and your new balance is " + total);
	};

}
