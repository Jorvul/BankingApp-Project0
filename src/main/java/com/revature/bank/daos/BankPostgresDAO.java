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
	PreparedStatement ptsmt;
		ResultSet rs;
		


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
				String account2 = rs.getString("account_type2");
				c=new Customer(id,name, bal, account, account2);
				customer.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	}

	@Override
	public boolean createCustomer(Customer customer) {
		try(Connection conn=ConnectionUtils.createConnection();) {
			PreparedStatement pstmt= conn.prepareStatement("insert into bank values(?,?,?,?,?)");
			pstmt.setInt(1, customer.getCustomerId());
			pstmt.setString(2, customer.getName());
			pstmt.setDouble(3, customer.getBalance());
			pstmt.setString(4,customer.getAccountName());
			pstmt.setString(5, customer.getAccountType2());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
		return true;
		
	}

	@Override
	public List<Customer> getCustomerById(int c) {
		ArrayList<Customer> customer = new ArrayList<Customer>();
		try(Connection conn=ConnectionUtils.createConnection();) {
			String selectCustomer = "select * from bank where customer_id=?";
			ptsmt = conn.prepareStatement(selectCustomer);
			ptsmt.setInt(1,c);
			rs = ptsmt.executeQuery();
			Customer c1;
			while(rs.next()) {
				int id = rs.getInt("customer_id");
				String name = rs.getString("customer_name");
				Double balance = rs.getDouble("balance");
				String accountName = rs.getString("account_type");
				String accountType2 = rs.getString("account_type2");
				c1 = new Customer(id,name, balance, accountName, accountType2);
				customer.add(c1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		try (Connection conn= ConnectionUtils.createConnection();){
			PreparedStatement pstmt = conn.prepareStatement("delete from bank where customer_id=?");
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	@Override
	public Customer updateCustomerById(Customer customer, int id1) {
		try(Connection conn= ConnectionUtils.createConnection();){
			 ptsmt = conn.prepareStatement("update bank set customer_name=? where customer_id=?");
			ptsmt.setString(1,customer.getName());
			ptsmt.setInt(2, id1);
			ptsmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customer;
	
	}

	@Override
	public Customer createAccountById(Customer customer, int id) {
		try(Connection conn = ConnectionUtils.createConnection();){
			PreparedStatement pstmt = conn.prepareStatement("update bank set account_type2=? where customer_id=?");
			pstmt.setString(1,customer.getAccountName());
			pstmt.setInt(2, id);
			pstmt.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> getAccountForCustomerById(int id, String account) {
		ArrayList<Customer> customer = new ArrayList<Customer>();
		try(Connection conn = ConnectionUtils.createConnection();) {
			String selectCustomer = "select * from bank where customer_id=?";
			ptsmt = conn.prepareStatement(selectCustomer);
			ptsmt.setInt(1,id);
			String selectAccount = "select * from bank where account_type=? and account_type2=?";
			PreparedStatement ptsmt1 = conn.prepareStatement(selectAccount);
			ptsmt1.setString(1,account);
			 rs = ptsmt.executeQuery();
			Customer c1;
			while(rs.next()) {
				int id1 = rs.getInt("customer_id");
				String name = rs.getString("customer_name");
				Double balance = rs.getDouble("balance");
				String accountName = rs.getString("account_type");
				String accountType2 = rs.getString("account_type2");
				c1 = new Customer(id1, name, balance, accountName, accountType2);
				customer.add(c1);
			}
			rs.close();
			ptsmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
}
