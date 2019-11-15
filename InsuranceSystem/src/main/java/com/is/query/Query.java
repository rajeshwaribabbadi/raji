package com.is.query;

/**
 * 
 * @author RAJESHWARI BABBADI
 *Created separate interface for Queries to update or delete the queries here.
 *The purpose of this interface is not to disturb the java code when we make changes in queries
 */
public interface Query {
	public String insert_policy = "insert into policy values(?,?,?,?,?,?)";
	public String view_policy = "select * from policy where policyid=? & status='active'";
	public String view_all_policy = "select * from policy where status='active'";
	public String update_policy_name ="update policy set policyname=? where policyid=?";
	public String update_policy_amount ="update policy set policyamount=? where policyid=?";
	public String update_policy_paidamount ="update  set paidamount=? where policyid=?";
	public String delete_policy_id="update policy set  status='inactive' where policyid=?";
	public String insert_customer = "insert into customer values(?,?,?,?,?,?)";
	public String view_customer = "select * from customer where customerid=?";
	public String view_all_customers = "select * from customer";
	public String insert_manager = "insert into manager values(?,?,?)";
	public String insert_agent = "insert into agent values(?,?,?,?)";
	public String view_agent = "select * from agent where agentid=?";
	public String view_all_agents = "select * from agent";
	public String view_customer_policy_details="select p.policyname,p.policyamount,"
			+ "p.paidamount,p.dueamount,c.customername,c.mobilenumber from policy p,customer c where c.policyid=?";
	
}
