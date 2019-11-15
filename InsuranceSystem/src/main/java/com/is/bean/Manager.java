package com.is.bean;
/**
 * 
 * @author RAJESHWARI BABBADI
 *This is a class contains encapsulation.
 */
public class Manager {
	private int managerid;
	private String managername;
	private int agentid;
public Manager(){}
public Manager(int managerid, String managername, int agentid) {
	super();
	this.managerid = managerid;
	this.managername = managername;
	this.agentid = agentid;
}
public int getManagerid() {
	return managerid;
}
public void setManagerid(int managerid) {
	this.managerid = managerid;
}
public String getManagername() {
	return managername;
}
public void setManagername(String managername) {
	this.managername = managername;
}
public int getAgentid() {
	return agentid;
}
public void setAgentid(int agentid) {
	this.agentid = agentid;
}
public String toString(){
	return managerid+"\t"+managername+"\t"+agentid;
}
}
