package com.is.bean;
/**
 * 
 * @author RAJESHWARI BABBADI
 *This is a class contains encapsulation.
 */
public class Policy {
	private int policyid;
	private String policyname;
	private double policyamount;
	private double paidamount;
	private double dueamount;
	private String status;
	 public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Policy(){}
	public Policy(int policyid, String policyname, double policyamount, double paidamount, double dueamount,String status) {
		super();
		this.policyid = policyid;
		this.policyname = policyname;
		this.policyamount = policyamount;
		this.paidamount = paidamount;
		this.dueamount = dueamount;
		this.status=status;
	}
	public int getPolicyid() {
		return policyid;
	}
	public void setPolicyid(int policyid) {
		this.policyid = policyid;
	}
	public String getPolicyname() {
		return policyname;
	}
	public void setPolicyname(String policyname) {
		this.policyname = policyname;
	}
	public double getPolicyamount() {
		return policyamount;
	}
	public void setPolicyamount(double policyamount) {
		this.policyamount = policyamount;
	}
	public double getPaidamount() {
		return paidamount;
	}
	public void setPaidamount(double paidamount) {
		this.paidamount = paidamount;
	}
	public double getDueamount() {
		return dueamount;
	}
	public void setDueamount(double dueamount) {
		this.dueamount = dueamount;
	}
	 public String toString(){
		 return policyid+"\t"+policyname+"\t"+policyamount+"\t"+paidamount+"\t"+dueamount;
	 }
	

}
