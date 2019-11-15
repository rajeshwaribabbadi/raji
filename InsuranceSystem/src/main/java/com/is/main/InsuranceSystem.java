package com.is.main;

import java.util.Scanner;
/**
 * This is the main class contains all the module information
 */

import com.is.menus.InsuranceDetails;

public class InsuranceSystem {

	public static void main(String[] args) {
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("--------------------------------------------");
			System.out.println("|          INSURANCE SYSTEM                |");
			System.out.println("--------------------------------------------");
			System.out.println("|            1.  CHAIRMAN                  |");
			System.out.println("|            2.  MANAGER                   |");
			System.out.println("|            3.  AGENT                     |");
			System.out.println("|            4.  CUSTOMER                  |");
			System.out.println("|            5.  EXIT                      |");
			System.out.println("ENTER YOUR CHOICE");
			int choice  = sc.nextInt();
			switch(choice){
			case 1:
				InsuranceDetails.chairmanMenu();
				break;
			case 2:
				InsuranceDetails.managerMenu();
				break;
			case 3:
				InsuranceDetails.agentMenu();			
				break;
			case 4:
				InsuranceDetails.customerMenu();
				
				break;
			case 5:
				System.exit(0);
				break;
			default :
				System.out.println("please select range 1-5 only");
			}
		}
		

	}
}
