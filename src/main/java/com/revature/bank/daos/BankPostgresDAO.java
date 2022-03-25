package com.revature.bank.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.Customer;
import com.revature.jdbc.ConnectionUtils;

public class BankPostgresDAO implements BankDAO {

	@Override
	public List<Customer> getCustomers() {
		ResultSet rs;
		PreparedStatement ptsmt;
		Connection conn = ConnectionUtils.createConnection();
		
		ArrayList<Customer> customer = new ArrayList<Customer>();
		try {
			String selectCustomers = "select * from bank";
			ptsmt = conn.prepareStatement(selectCustomers);
			rs=ptsmt.executeQuery();
			Customer c;
			while(rs.next()) {
				int id = rs.getInt("customer_id");
				String name = rs.getString("customer_name");
				int bal = rs.getInt("balance");
				String account = rs.getString("account_type");
				c=new Customer(id,name, bal, account);
				customer.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	}

}
