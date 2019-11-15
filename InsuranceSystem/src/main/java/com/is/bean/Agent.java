package com.is.bean;
/**
 * 
 * @author RAJESHWARI BABBADI
 *This is a class contains encapsulation. 
 */

public class Agent {
	private int agentid;
	private String agentname;
	private int policyid;
	private int customerid;
	public Agent(){}
	public Agent(int agentid, String agentname, int policyid, int customerid) {
		super();
		this.agentid = agentid;
		this.agentname = agentname;
		
		this.policyid = policyid;
		this.customerid = customerid;
	}
	public int getAgentid() {
		return agentid;
	}
	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}
	public String getAgentname() {
		return agentname;
	}
	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}
	public int getPolicyid() {
		return policyid;
	}
	public void setPolicyid(int policyid) {
		this.policyid = policyid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
	public String toString(){
		return agentid+"\t"+agentname+"\t"+policyid+"\t"+customerid;
	}

}
