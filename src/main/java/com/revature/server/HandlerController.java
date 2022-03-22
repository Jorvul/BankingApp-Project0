package com.revature.server;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.revature.bank.CheckingAccount;
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
			customer.add(c);
		}
		rs.close();
		ptsmt.close();
		ctx.json(customer);
	};
	
	public static Handler createCustomer = ctx ->{
			Customer customer = ctx.bodyAsClass(Customer.class);
			Connection conn=ConnectionUtils.createConnection();
			PreparedStatement pstmt= conn.prepareStatement("insert into bank values(?,?,?)");
			pstmt.setInt(1, customer.getCustomerId());
			pstmt.setString(2, customer.getName());
			pstmt.setDouble(3, customer.getBalance());
			pstmt.execute();
			ctx.status(201);
		 };
		

	public static Handler getCustomerbyId = ctx->{
		int c = Integer.parseInt(ctx.pathParam("customer_id"));
		Connection conn=ConnectionUtils.createConnection();
		String selectCustomer = "select * from bank where customer_id=?";
		PreparedStatement ptsmt = conn.prepareStatement(selectCustomer);
		ptsmt.setInt(1,c);
		ResultSet rs = ptsmt.executeQuery();
		ArrayList<Customer> customer = new ArrayList<Customer>();
		Customer c1;
		while(rs.next()) {
			int id = rs.getInt("customer_id");
			String name = rs.getString("customer_name");
			Double balance = rs.getDouble("balance");
			c1 = new Customer(id,name, balance);
			customer.add(c1);
		}
		ctx.json(customer);
		rs.close();
		ptsmt.close();
	};
	
	public static Handler updateCustomer=ctx->{
		int id = Integer.parseInt(ctx.pathParam("customer_id"));
		Customer customer=ctx.bodyAsClass(Customer.class);
		Connection conn= ConnectionUtils.createConnection();
		PreparedStatement pstmt = conn.prepareStatement("update bank set customer_name=? where customer_id=?");
		pstmt.setString(1,customer.getName());
		pstmt.setInt(2, id);
		pstmt.execute();
		ctx.status(200);
	};
	
	public static Handler withdrawFunds = ctx -> {
		int num = Integer.parseInt(ctx.pathParam("n1"));
		double balance = 30000.00;
		double total = balance - num;
		ctx.result("You withdrew a total " + num + " and your new balance is " + total);
	};

}
