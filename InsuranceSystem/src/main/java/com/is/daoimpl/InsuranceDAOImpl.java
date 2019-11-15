package com.is.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.is.bean.Agent;
import com.is.bean.Customer;
import com.is.bean.Manager;
import com.is.bean.Policy;
import com.is.dao.InsuranceDAO;
import com.is.db.DBUtil;
import com.is.main.InsuranceSystem;
import com.is.query.Query;
/**
 * 
 * @author NAVYA REDDY
 *This is the implementation class used to implement the unimplemented methods
 *Exceptions are used for the normal flow of execution
 */
public class InsuranceDAOImpl implements InsuranceDAO {
	PreparedStatement ps = null;
	Connection con = DBUtil.getConnection();;
	Policy policy = null;
	List<Policy> policies = null;
	Customer customer = null;
	List<Customer> customers = null;
	Manager manager = null;
	Agent agent = null;
	List<Agent> agents = null;
	Policy p = null;
	Scanner sc = new Scanner(System.in);
/**
 * @author NAVYA REDDY
 * This is add policy method which is used to add the details which are available in policy class
 */
	public void addPolicy() {
		int i = 1;
		while (i == 1) {
			try {
				ps = con.prepareStatement(Query.insert_policy);
				System.out.println("Enter policy id?");
				String policyid=sc.next();
				while(!Pattern.matches("\\d{2}", policyid)){
					System.err.println("please enter policy id should be in digits only ex:12");
					policyid=sc.next();
					
				}
				int id=Integer.parseInt(policyid);
				ps.setInt(1, id);
				
				System.out.println("Enter policy type?");
				String policyname=sc.next();
				while(!Pattern.matches("[A-Za-z]{13}",policyname))
				{
					System.err.println("please enter only 10 alphabets ex:Abcd");
					policyname=sc.next();
				}
				ps.setString(2, policyname);
				
				System.out.println("Enter policy amount?");
				String policyamount=sc.next();
				while(!Pattern.matches("\\d{5}",policyamount)){
					System.err.println("please enter policy amount in digits only ex.1234");
					policyamount=sc.next();
				}
				double amount=Double.parseDouble(policyamount);
				ps.setDouble(3, amount);
				
				System.out.println("Enter policy paidamount?");
				String paidamount=sc.next();
				while(!Pattern.matches("\\d{4}", paidamount)){
					System.err.println("please enter paid amount in digits only ex.2345");
					paidamount=sc.next();
				}
				double pamount=Double.parseDouble(paidamount);
				ps.setDouble(4, pamount);
				
				double dueamount = amount-pamount;
			    ps.setDouble(5, dueamount);
			    ps.setString(6, "active");

				int n = ps.executeUpdate();
				if (n != 0) {
					System.out.println("one record inserted successfully");
				} else {
					System.out.println("record not inserted.please try again...");
				}
				System.out.println("do you want to add more records press 1 only else any number");
				i = sc.nextInt();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					ps.close();

				} catch (SQLException e) {
				}
			}
		}
		}
	
	/**
	 * This is the view all policy method to display all the policy details
	 */

	public List<Policy> viewAllPolicy() {
		policies = new ArrayList<Policy>();
		try {
			ps = con.prepareStatement(Query.view_all_policy);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Policy();
				p.setPolicyid(rs.getInt(1));
				p.setPolicyname(rs.getString(2));
				p.setPolicyamount(rs.getDouble(3));
				p.setPaidamount(rs.getDouble(4));
				p.setDueamount(rs.getDouble(5));
				p.setStatus(rs.getString(6));
				policies.add(p);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return policies;
	}
	
	/**
	 * This is the view policy method to display the particular policy details
	 */

	public Policy viewPolicy(int policyid) {
		Policy policy = new Policy();
		try {
			ps = con.prepareStatement(Query.view_policy);
			ps.setInt(1, policyid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				policy.setPolicyid(rs.getInt(1));
				policy.setPolicyname(rs.getString(2));
				policy.setPolicyamount(rs.getDouble(3));
				policy.setPaidamount(rs.getDouble(4));
				policy.setDueamount(rs.getDouble(5));
				policy.setStatus(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return policy;
	}
	
	/**
	 * This is the update policy method to update policy details based on policy id
	 */

	public void updatePolicy(int policyid) {
		int n = 0;
		System.out.println("select your choice 1.policyname 2.policyamount 3.paidamount");
		int choice = sc.nextInt();
		try {
			switch (choice) {
			case 1:
				ps = con.prepareStatement(Query.update_policy_name);
				System.out.println("enter updating policy name?");
				String policyname=sc.next();
				while(!Pattern.matches("\\w*",policyname))
				{
					System.err.println("please enter only alphabets ex:Abcd");
					policyname=sc.next();
				}
	
				ps.setString(1, policyname);
				ps.setInt(2, policyid);
				n = ps.executeUpdate();
				if (n != 0) {
					System.out.println("policy name updated successfully");
				} else {
					System.out.println("policy name not updated..please try again");

				}
				break;
				
			case 2:
				ps = con.prepareStatement(Query.update_policy_amount);
				System.out.println("enter updating policy amount?");
				String policyamount=sc.next();
				while(!Pattern.matches("\\d{5}",policyamount)){
					System.err.println("please enter policy amount in digits only ex.1234");
					policyamount=sc.next();
				}
				double amount=Double.parseDouble(policyamount);
				

				ps.setDouble(1, amount);
				ps.setInt(2, policyid);
				n = ps.executeUpdate();
				if (n != 0) {
					System.out.println("policy amount updated successfully");
				} else {
					System.out.println("policy amount not updated..please try again");

				}
				break;
				
			case 3:
				ps = con.prepareStatement(Query.update_policy_paidamount);
				System.out.println("enter updating policy paid amount?");
				String paidamount=sc.next();
				while(!Pattern.matches("\\d{4}", paidamount)){
					System.err.println("please enter paid amount in digits only ex.2345");
					paidamount=sc.next();
				}
				double pamount=Double.parseDouble(paidamount);
				ps.setDouble(1, pamount);
				ps.setInt(2, policyid);
				n = ps.executeUpdate();
				if (n != 0) {
					System.out.println("policy paidamount updated successfully");
				} else {
					System.out.println("policy paidamount not updated..please try again");

				}
				break;
				
			default:
				System.out.println("select the choice 1-3 only");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This is the delete policy method to delete the record.
	 * Here we used status not to delete the record in database ex:default status is active.
	 */
	public void deletePolicy(int policyid) {

		try {
			ps = con.prepareStatement(Query.delete_policy_id);
			ps.setInt(1, policyid);
			int n = ps.executeUpdate();
			if (n != 0) {
				System.out.println("policy id record deleted successfully");
			} else {
				System.out.println("policy id record not deleted..please try again");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * This is add customer method which is used to add the details which are available in customer class
	 */

	public void addCustomer() {
		int i = 1;
		while (i == 1) {
			try {
				ps = con.prepareStatement(Query.insert_customer);
				System.out.println("Enter customer id?");
				String customerid=sc.next();
				while(!Pattern.matches("\\d{2}", customerid)){
					System.err.println("please enter customer id should be 2 digits only ex:12");
					customerid=sc.next();
					}
				int id=Integer.parseInt(customerid);
				ps.setInt(1, id);
				
				System.out.println("Enter customer name?");
				String customername=sc.next();
				while(!Pattern.matches("\\w*", customerid)){
					System.err.println("please enter customer name should be in alphabets only ex:Abcd");
					customername=sc.next();
				}
				ps.setString(2, customername);
				
				System.out.println("Enter customer mobilenumber?");
				String mobilenumber=sc.next();
				while(!Pattern.matches("\\d{10}", mobilenumber)){
					System.err.println("please enter policy id should be in digits only ex:1234567890");
					mobilenumber=sc.next();
					}
				long mno=Long.parseLong(mobilenumber);
				ps.setLong(3, mno);
				
				System.out.println("Enter customer emailid?");
				String emailid=sc.next();
				while(!Pattern.matches("\\w*+@+[a-z]{5}+.+[a-z]{3}", emailid)){
					System.err.println("please enter email id format ex:navya96@gmail.com");
					emailid=sc.next();
					}
				ps.setString(4, emailid);
				
				System.out.println("Enter customer address?");
				String address=sc.next();
				while(!Pattern.matches("\\w*", address)){
					System.err.println("please enter policy id should be alphabtes only ex:abcdef");
					address=sc.next();
				}
				ps.setString(5, address);
				
				System.out.println("Enter policy id?");
				String policyid=sc.next();
				while(!Pattern.matches("\\d{2}", policyid)){
					System.err.println("please enter policy id should be in digits only ex:12");
					policyid=sc.next();
				}
				int id1=Integer.parseInt(policyid);
				ps.setInt(6, id1);
				
				int n = ps.executeUpdate();
				if (n != 0) {
					System.out.println("one record inserted successfully");
				} else {
					System.out.println("record not inserted.please try again...");
				}
				System.out.println("do you want to add more records press 1 only else any number");
				i = sc.nextInt();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					ps.close();

				} catch (SQLException e) {
				}
			}
		}
	}
	
	/**
	 * This is the view all customers method to display all the customer details
	 */

	public List<Customer> viewAllCustomers() {
		customers = new ArrayList<Customer>();
		Customer c = null;
		try {
			ps = con.prepareStatement(Query.view_all_customers);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Customer();
				c.setCustomerid(rs.getInt(1));
				c.setCustomername(rs.getString(2));
				c.setEmailid(rs.getString(4));
				c.setAddress(rs.getString(5));
				c.setPolicyid(rs.getInt(6));
				customers.add(c);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return customers;
	}
	/**
	 * This is the view customer method to display the particular customer details
	 */

	public Customer viewCustomer(int customerid) {
		Customer customer = new Customer();
		try {
			ps = con.prepareStatement(Query.view_customer);
			ps.setInt(1, customerid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer.setCustomerid(rs.getInt(1));
				customer.setCustomername(rs.getString(2));
				customer.setMobilenumber(rs.getLong(3));
				customer.setEmailid(rs.getString(4));
				customer.setAddress(rs.getString(5));
				customer.setPolicyid(rs.getInt(6));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return customer;
	}
	/**
	 * This is add manager method which is used to add the details which are available in manager class
	 */

	public void addManager() {
		int i = 1;
		while (i == 1) {
			try {
				ps = con.prepareStatement(Query.insert_manager);
				System.out.println("Enter manager id?");
				String managerid=sc.next();
				while(!Pattern.matches("\\d{1}", managerid)){
					System.err.println("please enter policy id should be 1 digit only ex:1");
					managerid=sc.next();
					
				}
				int id=Integer.parseInt(managerid);
				ps.setInt(1, id);
				
				System.out.println("Enter manager name?");
				String managername=sc.next();
				while(!Pattern.matches("\\w*", managerid)){
					System.err.println("please enter manager name should be in alphabets only ex:Abcd");
					managername=sc.next();
				}	
				ps.setString(2, managername);
				
				System.out.println("Enter agent id?");
				String agentid=sc.next();
				while(!Pattern.matches("\\d{3}", agentid)){
					System.err.println("please enter agent id should be in 3 digits only ex:123");
					agentid=sc.next();
					}
				int id2=Integer.parseInt(agentid);
				ps.setInt(3, id2);
				
				int n = ps.executeUpdate();
				if (n != 0) {
					System.out.println("one record inserted successfully");
				} else {
					System.out.println("record not inserted.please try again...");
				}
				System.out.println("do you want to add more records press 1 only else any number");
				i = sc.nextInt();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					ps.close();

				} catch (SQLException e) {
				}}
		
		}}

	/**
	 * This is add agent method which is used to add the details which are available in agent class
	 */

	public void addAgent() {
		int i = 1;
		while (i == 1) {
			try {
				ps = con.prepareStatement(Query.insert_agent);
				System.out.println("Enter agent id?");
				String agentid=sc.next();
				while(!Pattern.matches("\\d{3}", agentid)){
					System.err.println("please enter agent id should be 3 digits only ex:123");
					agentid=sc.next();
					}
				int id=Integer.parseInt(agentid);
				ps.setInt(1, id);
				
				System.out.println("Enter agent name?");
				String agentname=sc.next();
				while(!Pattern.matches("\\w*", agentid)){
					System.err.println("please enter manager name should be in alphabets only ex:Abcd");
					agentname=sc.next();
				}
				ps.setString(2, agentname);
				
				System.out.println("Enter policy id?");
				String policyid=sc.next();
				while(!Pattern.matches("\\d{2}", policyid)){
					System.err.println("please enter policy id should be in digits only ex:12");
					policyid=sc.next();
					
				}
				int id1=Integer.parseInt(policyid);
				ps.setInt(3, id1);
				
				System.out.println("Enter customer id?");
				String customerid=sc.next();
				while(!Pattern.matches("\\d{2}", customerid)){
					System.err.println("please enter customer id should be in digits only ex:12");
					customerid=sc.next();
					}
				int id2=Integer.parseInt(customerid);
				ps.setInt(4, id2);
				
				int n = ps.executeUpdate();
				if (n != 0) {
					System.out.println("one record inserted successfully");
				} else {
					System.out.println("record not inserted.please try again...");
				}
				System.out.println("do you want to add more records press 1 only else any number");
				i = sc.nextInt();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					ps.close();

				} catch (SQLException e) {
				}
			}
		}

	}
	/**
	 * This is the view all agents method to display all the agent details
	 */

	public List<Agent> viewAllAgents() {
		agents = new ArrayList<Agent>();
		Agent a = null;
		try {
			ps = con.prepareStatement(Query.view_all_agents);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Agent();
				a.setAgentid(rs.getInt(1));
				a.setAgentname(rs.getString(2));
	            a.setPolicyid(rs.getInt(3));
				a.setCustomerid(rs.getInt(4));
				agents.add(a);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return agents;

	}
	
	/**
	 * This is the view agent method to display the particular agent details
	 */

	public Agent viewAgent(int agentid) {
		Agent agent = new Agent();
		try {
			ps = con.prepareStatement(Query.view_agent);
			ps.setInt(1, agentid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				agent.setAgentid(rs.getInt(1));
				agent.setAgentname(rs.getString(2));
				agent.setPolicyid(rs.getInt(3));
				agent.setCustomerid(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return agent;
	}

	public void due() {
		double dueamount=p.getPolicyamount()-p.getPaidamount();

	}
	public void customerPolicyDetails(int policyid){
		
		
		try {
			ps = con.prepareStatement(Query.view_customer_policy_details);
			ps.setInt(1, policyid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getDouble(2)+"\t"+
			rs.getDouble(3)+"\t"+rs.getDouble(4)+"\t"+rs.getString(5)+"\t"+rs.getLong(6));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
	}
	

	public void back() {
		InsuranceSystem.main(null);
	}

}
