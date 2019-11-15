package com.is.bean;
/**
 * 
 * @author RAJESHWARI BABBADI
 *This is a class contains encapsulation.
 */
public class Chairman {
private String chairmanname;
private int policyid;
private int managerid;
public Chairman(){}
public Chairman(String chairmanname, int policyid, int managerid) {
	super();
	this.chairmanname = chairmanname;
	this.policyid = policyid;
	this.managerid = managerid;
}
public String getChairmanname() {
	return chairmanname;
}
public void setChairmanname(String chairmanname) {
	this.chairmanname = chairmanname;
}
public int getPolicyid() {
	return policyid;
}
public void setPolicyid(int policyid) {
	this.policyid = policyid;
}
public int getManagerid() {
	return managerid;
}
public void setManagerid(int managerid) {
	this.managerid = managerid;
}
public String toString(){
	return chairmanname+"\t"+policyid+"\t"+managerid;
}
}
