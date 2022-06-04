package com.mushfiqur.rahman.emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {
	
	Scanner stdin = new Scanner(System.in);
	private String fname, lname, dept, email, password, alter_email;
	private int mailCapacity = 500;
	
	public Email(String fname, String lname) {
		
		this.fname = fname;
		this.lname = lname;
		
		System.out.println("New Employee: "+ this.fname+" "+this.lname);
		
		// calling methods
		this.dept = this.dept();
		this.password = this.generatePassword(8);
		this.email = this.generateEmail();
	}
	
	// generating mail method
	private String generateEmail() {
		
		return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
		
	}
	
	// generating dept method
	private String dept() {
		System.out.println("Department codes: \n1 for Sales \n2 for Development \n3 for Accounts \0 for None");
		boolean flag = false;
		
		do {
			System.out.println("Enter Department code: ");
			int choice = stdin.nextInt();
			switch(choice) {
			case 1:
				return "Sales";
			case 2:
				return "Development";
			case 3:
				return "Accounting";
			case 0:
				return "None";
			default:
				System.out.println("Invalid input!! Try Again!");
			}
		}while(!flag);
		
		return null;
		
	}
	
	// method for generating random password
	
	private String generatePassword(int length) {
		
		String password="";
		Random rand = new Random();
		String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallChars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%&?";
		String values = capitalChars+ smallChars+ numbers+ symbols;
		for(int i=0; i<length; i++){
			password = password+values.charAt(rand.nextInt(values.length()));
		}
		
		return password;
		
	}
	
	// change password method
	public void setPassword() {
		boolean flag= false;
		do {
			System.out.println("Do you want to change your password? (Y/N)");
			char choice = stdin.next().charAt(0);
			if(choice== 'Y' || choice== 'y') {
				flag = true;
				System.out.println("Enter current password: ");
				String temp = stdin.next();
				if(temp.equals(this.password)) {
					System.out.println("Enter new password: ");
					this.password = stdin.next();
					System.out.println("Password Changed!!");
				}
				else {
					System.out.println("Incorrect Password");
				}
				
			}
			else if(choice== 'N' || choice=='n' ) {
				System.out.println("Password choice option has been cancelled!!");
			}
			else {
				System.out.println("Enter Vvalid choice!!");
			}
		} while(!flag);
	}
	
	// method for setting mailbox capacity
	public void setMailCap() {
		
		System.out.println("Current capacity: "+ this.mailCapacity+"mb");
		System.out.println("Enter new mailbox capacity: ");
		this.mailCapacity = stdin.nextInt();
		System.out.println("Mailbox capacity is changed!!");
	}
	
	// setting alternative emails
	public void alterEmail() {
		System.out.println("Enter new alternate mail: ");
		this.alter_email = stdin.next();
		System.out.println("Alternative email is set!");
		
	}
	
	// method for displaying user info
	public void getInfo() {
		System.out.println("New: "+this.fname+" "+this.lname);
		System.out.println("Department: "+ this.dept);
		System.out.println("Email: "+ this.email);
		System.out.println("Password: "+this.password);
		System.out.println("Mailbox capacity: "+ this.mailCapacity+"mb");
		System.out.println("Alternative mail: "+ this.alter_email);
	}
	
	// storing all the generated data in a text file
	public void storeFile() {
		
		try {
			FileWriter in = new FileWriter("C:\\Users\\Mushfiqur Rahman\\Desktop\\info.txt");
			in.write("First name: "+this.fname);
			in.append("\nLast name: "+this.lname);
			in.append("\nEmail: "+this.email);
			in.append("\nPassword: "+this.password);
			in.append("\nMailbox capacity: "+ this.mailCapacity);
			in.append("\nAlternative mail: "+ this.alter_email);
			in.close();
			System.out.println("Data Stored.");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	// reading file method
	public void readFile() {
		
		try {
			FileReader f1 = new FileReader("C:\\Users\\Mushfiqur Rahman\\Desktop\\info.txt");
			int i;
			while((i=f1.read())!=-1) {
				
				System.out.print((char)i);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
