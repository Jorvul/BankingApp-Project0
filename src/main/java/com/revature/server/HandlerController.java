package com.revature.server;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.CheckingAccount;
import com.revature.bank.Customer;
import com.revature.bank.daos.BankDAO;
import com.revature.bank.daos.BankPostgresDAO;
import com.revature.jdbc.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;


import io.javalin.http.Handler;

public class HandlerController {
	
	  private BankDAO dao = new BankPostgresDAO();
	  public HandlerController(BankDAO dao) {
		  this.dao = dao;
	  }
	public Handler getCustomers = ctx ->{
//		ResultSet rs;
//		PreparedStatement ptsmt;
//		Connection conn = ConnectionUtils.createConnection();
//		
//		String selectCustomers = "select * from bank";
//		ptsmt = conn.prepareStatement(selectCustomers);
//		rs=ptsmt.executeQuery();
//		ArrayList<Customer> customer = new ArrayList<Customer>();
//		Customer c;
//		while(rs.next()) {
//			int id = rs.getInt("customer_id");
//			String name = rs.getString("customer_name");
//			int bal = rs.getInt("balance");
//			String account = rs.getString("account_type");
//			c=new Customer(id,name, bal, account);
//			customer.add(c);
//		}
//		rs.close();
//		ptsmt.close();
		List<Customer> customer = this.dao.getCustomers();
		ctx.json(customer);
	};
	
	public Handler createCustomer = ctx ->{
			Customer customer = ctx.bodyAsClass(Customer.class);
//			Connection conn=ConnectionUtils.createConnection();
//			PreparedStatement pstmt= conn.prepareStatement("insert into bank values(?,?,?,?)");
//			pstmt.setInt(1, customer.getCustomerId());
//			pstmt.setString(2, customer.getName());
//			pstmt.setDouble(3, customer.getBalance());
//			pstmt.setString(4,customer.getAccountName());
//			pstmt.execute();
			
			if(this.dao.createCustomer(customer)) {
				ctx.status(201);
			} else {
				ctx.status(404);
			}
		 };
		

	public Handler getCustomerById = ctx->{
	int c = Integer.parseInt(ctx.pathParam("customer_id"));
//	Connection conn=ConnectionUtils.createConnection();
//		String selectCustomer = "select * from bank where customer_id=?";
//		PreparedStatement ptsmt = conn.prepareStatement(selectCustomer);
//		ptsmt.setInt(1,c);
//		ResultSet rs = ptsmt.executeQuery();
//		ArrayList<Customer> customer = new ArrayList<Customer>();
//		Customer c1;
//		while(rs.next()) {
//			int id = rs.getInt("customer_id");
//			String name = rs.getString("customer_name");
//			Double balance = rs.getDouble("balance");
//			String accountName = rs.getString("account_type");
//			c1 = new Customer(id,name, balance, accountName);
//			customer.add(c1);
//		}
	List<Customer> customer = this.dao.getCustomerById(c);

		
		if(customer.size()==0) {ctx.status(404);}   
		else{ctx.json(customer);ctx.status(201);}


	};
	
	public Handler updateCustomer=ctx->{
		int id1 = Integer.parseInt(ctx.pathParam("customer_id"));
		Connection conn= ConnectionUtils.createConnection();
		Customer customer=ctx.bodyAsClass(Customer.class);
		PreparedStatement pstmt = conn.prepareStatement("update bank set customer_name=? where customer_id=?");
		pstmt.setString(1,customer.getName());
		pstmt.setInt(2, id1);
		pstmt.execute();
		ctx.status(200);
	};


		
	public static Handler deleteCustomer=ctx->{
		int id=Integer.parseInt(ctx.pathParam("customer_id"));
		Connection conn= ConnectionUtils.createConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from bank where customer_id=?");
		pstmt.setInt(1, id);
		pstmt.execute();
		ctx.status(205);
	


		

		
		
//		ResultSet rs = pstmt.executeQuery();
//		ArrayList<Customer> customer = new ArrayList<Customer>();
//		Customer c1;
//		while(rs.next()) {
//			int id1 = rs.getInt("customer_id");
//			String name = rs.getString("customer_name");
//			Double balance = rs.getDouble("balance");
//			String accountName = rs.getString("account_type");
//			c1 = new Customer(id1,name, balance, accountName);
//			customer.add(c1);
//		}
		
	
		
	};
	
	public static Handler createAccountById=ctx->{
		int id = Integer.parseInt(ctx.pathParam("customer_id"));
		String account = ctx.pathParam("account_type");
		Customer customer=ctx.bodyAsClass(Customer.class);
		Connection conn= ConnectionUtils.createConnection();
		PreparedStatement pstmt = conn.prepareStatement("update bank set account_type=? where customer_id=?");
		pstmt.setString(1,customer.getAccountName());
		pstmt.setInt(2, id);
		pstmt.execute();
		ctx.status(201);
	};
	
	public static Handler getAccountForCustomerById=ctx->{
		int id = Integer.parseInt(ctx.pathParam("customer_id"));
		String account = ctx.pathParam("account_type");
		Connection conn = ConnectionUtils.createConnection();
		String selectCustomer = "select * from bank where customer_id=?";
		PreparedStatement ptsmt = conn.prepareStatement(selectCustomer);
		ptsmt.setInt(1,id);
		String selectAccount = "select * from bank where account_type=?";
		PreparedStatement ptsmt1 = conn.prepareStatement(selectAccount);
		ptsmt1.setString(1,account);
		ResultSet rs = ptsmt.executeQuery();
		ArrayList<Customer> customer = new ArrayList<Customer>();
		Customer c1;
		while(rs.next()) {
			int id1 = rs.getInt("customer_id");
			String name = rs.getString("customer_name");
			Double balance = rs.getDouble("balance");
			String accountName = rs.getString("account_type");
			c1 = new Customer(id1,name, balance, accountName);
			customer.add(c1);
		}
		if(customer.size()==0)
			ctx.status(404);
		ctx.json(customer);
	};
	
	
	public static Handler withdrawFunds = ctx -> {
		int num = Integer.parseInt(ctx.pathParam("n1"));
		double balance = 30000.00;
		double total = balance - num;
		ctx.result("You withdrew a total " + num + " and your new balance is " + total);
	};

}
