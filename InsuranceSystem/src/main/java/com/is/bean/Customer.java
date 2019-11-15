package com.is.bean;
/**
 * 
 * @author RAJESHWARI BABBADI
 *This is a class contains encapsulation.
 */
public class Customer {
private int customerid;
private String customername;
private long mobilenumber;
private String emailid;
private String address;
private int policyid;
 public Customer(){}
public Customer(int customerid, String customername, long mobilenumber, String emailid, String address, int policyid) {
	super();
	this.customerid = customerid;
	this.customername = customername;
	this.mobilenumber = mobilenumber;
	this.emailid = emailid;
	this.address = address;
	this.policyid = policyid;
}
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}
public long getMobilenumber() {
	return mobilenumber;
}
public void setMobilenumber(long mobilenumber) {
	this.mobilenumber = mobilenumber;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getPolicyid() {
	return policyid;
}
public void setPolicyid(int policyid) {
	this.policyid = policyid;
}
public String toString(){
	return customerid+"\t"+customername+"\t"+mobilenumber+"\t"+emailid+"\t"+address+"\t"+policyid;
}
 }
