package com.is.dao;

import java.util.List;

import com.is.bean.Agent;
import com.is.bean.Customer;
import com.is.bean.Policy;

/**
 * 
 * @author RAJESHWARI BABBADI
 *this interface contains methods which are to access the objects
 */

public interface InsuranceDAO {

	public void addPolicy();
	public List<Policy> viewAllPolicy();
	public Policy viewPolicy(int policyid);
	public void updatePolicy(int policyid);
	public void deletePolicy(int policyid);
	public void addCustomer();
	public List<Customer> viewAllCustomers();
	public Customer viewCustomer(int customerid);
	public void addManager();
	public void addAgent();
	public List<Agent> viewAllAgents();
	public Agent viewAgent(int agentid);
	public void due();
	public void back();
	public void customerPolicyDetails(int policyid);

}
