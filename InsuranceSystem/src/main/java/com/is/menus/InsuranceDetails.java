package com.is.menus;

import java.util.List;
import java.util.Scanner;

import com.is.bean.Agent;
import com.is.bean.Customer;
import com.is.bean.Policy;
import com.is.daoimpl.InsuranceDAOImpl;

/**
 * 
 * @author JAGADISH
 *This is the menu class used to create main menus for each class
 */

public class InsuranceDetails {
	static Scanner sc = new Scanner(System.in);
	static InsuranceDAOImpl insuranceDAO = new InsuranceDAOImpl();

	public static void customerMenu() {
		System.out.println("-----------------------------");
		System.out.println("|     CUSTOMER MAIN MENU    |");
		System.out.println("-----------------------------");
		System.out.println("|  1. VIEW POLICY           |");
		System.out.println("|  2. BACK                  |");
		System.out.println("----------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter Search policyid ?");
			Policy po = insuranceDAO.viewPolicy(sc.nextInt());
			System.out.println("policyid" + 
			"\t" + "policyname" + "\t" + "policyamount"+"\t"+"paidamount"+"\t"+"Dueamount");
			System.out.println("-----------------------------");
			System.out.println(po);
			customerMenu();
			break;
		case 2:
			insuranceDAO.back();
			break;
		default:
			System.out.println("please select range 1-2 only");
		}
	}

	public static void agentMenu() {
		System.out.println("-----------------------------------");
		System.out.println("|     AGENT MAIN MENU             |");
		System.out.println("-----------------------------------");
		System.out.println("|  1. ADD CUSTOMER                |");
		System.out.println("|  2. VIEW  CUSTOMER              |");
		System.out.println("|  3. VIEW ALL CUSTOMERS          |");
		System.out.println("|  4. BACK                        |");
		System.out.println("----------------------------");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:

			insuranceDAO.addCustomer();
			agentMenu();
			break;
		case 2:
			System.out.println("Enter customer id  ?");
			Customer customer = insuranceDAO.viewCustomer(sc.nextInt());
			System.out.println("customerid" + 
					"\t" + "customername" + "\t" + "mobilenumber"+"\t"+"emailid"+"\t"+"address"+"\t"+"policyid");
					System.out.println("-----------------------------");
			System.out.println(customer);
			agentMenu();
			break;
		case 3:
			List<Customer> customers = insuranceDAO.viewAllCustomers();
			System.out.println("customerid" + 
					"\t" + "customername" + "\t" + "mobilenumber"+"\t"+"emailid"+"\t"+"address"+"\t"+"policyid");
					System.out.println("-----------------------------");
			System.out.println("-----------------------------");
			for (Customer c : customers) {
				System.out.println(c);
			}
			agentMenu();
		case 4:
			insuranceDAO.back();
		default:

		}
	}

	public static void managerMenu() {
		System.out.println("----------------------------");
		System.out.println("|     MANAGER MAIN MENU      |");
		System.out.println("----------------------------");
		System.out.println("|  1. ADD AGENT         |");
		System.out.println("|  2. VIEW  AGENT         |");
		System.out.println("|  3. VIEW ALL AGENTS     |");
		System.out.println("|  4. VIEW ALL CUSTOMERS  |");
		System.out.println("|  5. BACK                |");
		System.out.println("----------------------------");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:

			insuranceDAO.addAgent();
			managerMenu();

			break;
		
		case 2:
			System.out.println("Enter agent id?");
			Agent agent = insuranceDAO.viewAgent(sc.nextInt());
			System.out.println("agentid" + "\t" + "agentname" + "\t" + "policyid"+"\t"+"customerid");
			System.out.println("-----------------------------");
			System.out.println(agent);
			managerMenu();
			break;
		case 3:
			List<Agent> agents = insuranceDAO.viewAllAgents();
			System.out.println("agentid" + "\t" + "agentname" + "\t" + "policyid"+"\t"+"customerid");
			System.out.println("-----------------------------");
			for (Agent a : agents) {
				System.out.println(a);
			}
			managerMenu();
		case 4:
			List<Customer> customers = insuranceDAO.viewAllCustomers();
			System.out.println("customerid" + 
					"\t" + "customername" + "\t" + "mobilenumber"+"\t"+"emailid"+"\t"+"address"+"\t"+"policyid");
			System.out.println("-----------------------------");
			for (Customer c : customers) {
				System.out.println(c);
			}
			managerMenu();

		case 5:
			insuranceDAO.back();

		default:
			System.out.println("please enter in range 1-5 only");
		}
	}

	public static void chairmanMenu() {
		System.out.println("-------------------------------");
		System.out.println("|     CHAIRMAN MAIN MENU      |");
		System.out.println("-------------------------------");
		System.out.println("|  1. ADD POLICY              |");
		System.out.println("   2. ADD MANAGER             |");
		System.out.println("|  3. VIEW  POLICY            |");
		System.out.println("|  4. UPDATE POLICY           |");
		System.out.println("|  5. DELETE POLICY           |");
		System.out.println("|  6. VIEW  ALL POLICIES      |");
		System.out.println("|  7. BACK                    |");
		System.out.println("-------------------------------");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			insuranceDAO.addPolicy();
			chairmanMenu();

			break;
		case 2:
			insuranceDAO.addManager();
			chairmanMenu();
		case 3:
			System.out.println("Enter Search policyid ?");
			Policy po = insuranceDAO.viewPolicy(sc.nextInt());
			System.out.println("policyid" + 
					"\t" + "policyname" + "\t" + "policyamount"+"\t"+"paidamount"+"\t"+"Dueamount");
			System.out.println("-----------------------------------------------------");
			System.out.println(po);
			chairmanMenu();
			break;
		case 4:
			System.out.println("enter the policy id to be updated");
			insuranceDAO.updatePolicy(sc.nextInt());
		    chairmanMenu();
			break;
		case 5:
			System.out.println("enter the policy id to be deleted");
			 insuranceDAO.deletePolicy(sc.nextInt());
			chairmanMenu();
			break;
		case 6:
			List<Policy> policies = insuranceDAO.viewAllPolicy();
			System.out.println("policyid" + 
					"\t" + "policyname" + "\t" + "policyamount"+"\t"+"paidamount"+"\t"+"Dueamount");
			System.out.println("---------------------------------------------------");
			for (Policy p1 : policies) {
				System.out.println(p1);
			}
			chairmanMenu();
			break;

		case 7:
			insuranceDAO.back();

			break;

		default:
			System.out.println("select range from 1-5 only");
		}
	}
}