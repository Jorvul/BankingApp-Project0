package com.revature.server;



import java.util.List;
import com.revature.bank.Customer;
import com.revature.bank.daos.BankDAO;
import com.revature.bank.daos.BankPostgresDAO;



import io.javalin.http.Handler;

public class HandlerController {
	
	  private BankDAO dao = new BankPostgresDAO();
	  public HandlerController(BankDAO dao) {
		  this.dao = dao;
	  }
	  
	public Handler getCustomers = ctx ->{
		List<Customer> customer = this.dao.getCustomers();
		ctx.json(customer);
	};
	
	public Handler createCustomer = ctx ->{
			Customer customer = ctx.bodyAsClass(Customer.class);
			
			if(this.dao.createCustomer(customer)) {
				ctx.status(201);
			} else {
				ctx.status(404);
			}
		 };
		

	public Handler getCustomerById = ctx->{
	int c = Integer.parseInt(ctx.pathParam("customer_id"));
	List<Customer> customer = this.dao.getCustomerById(c);
		if(customer.size()==0) {ctx.status(404);}   
		else{ctx.json(customer);ctx.status(201);}


	};
	
	public Handler updateCustomerById=ctx->{
		int id1 = Integer.parseInt(ctx.pathParam("customer_id"));
		Customer customer=ctx.bodyAsClass(Customer.class);
		List<Customer> daoUpdate = dao.getCustomerById(id1);
		if(daoUpdate.size()== 0) {
			ctx.status(404);
		} else {
			ctx.status(200);
		}
		this.dao.updateCustomerById(customer, id1);
	};


		
	public Handler deleteCustomer=ctx->{
		int id=Integer.parseInt(ctx.pathParam("customer_id"));
		List<Customer> daoDelete = dao.getCustomerById(id);
		if(daoDelete.size()== 0) {
			ctx.status(404);
		} else {
			ctx.status(205);
		}
		this.dao.deleteCustomer(id);

	};
	
	public Handler createAccountById=ctx->{
		int id = Integer.parseInt(ctx.pathParam("customer_id"));
		String account = ctx.pathParam("account_type2");
		Customer customer=ctx.bodyAsClass(Customer.class);
		ctx.status(201);
		this.dao.createAccountById(customer, id);
	};
	
	public Handler getAccountForCustomerById=ctx->{
		int id = Integer.parseInt(ctx.pathParam("customer_id"));
		String account = ctx.pathParam("account_type");
		List<Customer>customer = this.dao.getAccountForCustomerById(id, account);
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
