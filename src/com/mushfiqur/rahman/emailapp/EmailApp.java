package com.mushfiqur.rahman.emailapp;

import java.util.Scanner;

public class EmailApp {

	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		
		// user info
		System.out.println("Enter first name: ");
		String f_name = stdin.next();
		System.out.println("Enter last name: ");
		String l_name= stdin.next();
		
		// creating email object
		Email em1 = new Email(f_name, l_name);
		int choice= -1;
		do {
			System.out.println("\n******\nEnter your choice\n1. Show Info\n2. Change password\n3. Change mailbox capacity\n4. Set alternative mail\n5. Store data in file\n6. Display data from file \n7. Exit");
			choice = stdin.nextInt();
			switch(choice) {
			case 1:
				em1.getInfo();
				break;
			case 2:
				em1.setPassword();
				break;
			
			case 3:
				em1.setMailCap();
				break;
			case 4:
				em1.alterEmail();
				break;
			case 5:
				em1.storeFile();
				break;
			case 6:
				em1.readFile();
				break;
			case 7:
				System.out.println("Thank you for using the system!");
				break;
			default:
				System.out.println("Invalid choice! Enter proper choice again!!");
			
			}
		} while(choice!=7);

	}

}
