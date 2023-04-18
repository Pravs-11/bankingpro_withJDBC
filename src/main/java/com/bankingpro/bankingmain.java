package com.bankingpro;
import java.util.*;
//import java.sql.*;

public class bankingmain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
Scanner bs=new Scanner(System.in);
bankingdao dao=new bankingdao();
customer c1=new customer();
System.out.println("\t/t******Welcome to HDFC BANK***");

System.out.println("Press 1 for Registration \n Press 2 for login");
int operation=bs.nextInt();
switch(operation) {
case 1->{

System.out.println("Enter Customer name");
bs.nextLine();
String cname=bs.nextLine();
System.out.println("Enter customer id");
int cid=bs.nextInt();
System.out.println("Enter customer pin");
int cpin=bs.nextInt();
System.out.println("Enter customer amount");
int cbal=bs.nextInt();
c1.cusid=cid;
c1.cusname=cname;
c1.cuspin=cpin;
c1.cusamount=cbal;
dao.dbconnection();
int res =dao.registercustomer(c1);
if(res==1) {
	System.out.println("account registration successful");
}
else {
	System.out.println("Error, Not able to register");
}
}
case 2->{
	System.out.println("Welcome to login page");
	//Reading username and password from login
	System.out.println("Enter username");
	bs.nextLine();
	String uname=bs.nextLine();
	System.out.println("Enter Password");
	int pwd=bs.nextInt();
	//get connection with data base
	dao.dbconnection();
	//login method
	int res=dao.login(uname, pwd);
	//handling the response
	if(res==0) {
		System.out.println("username/password is incorrect");	
	}
	else if(res==-1) {
		System.out.println("Unable to find the customer details");	
		
	}
	else {
		System.out.println("Login successful");
		System.out.println("Press 1 for Deposit\nPress 2 for Withdraw\nPress 3 for change password\nPress 4 for Delete Acc");
		int process=bs.nextInt();
		switch(process) {
		case 1->{
			System.out.println("Enter amount to deposit");
			int amount=bs.nextInt();
			int bal=dao.deposit(amount,res);
			System.out.println("Deposit successful\n Available balance is : "+bal);
		}
		case 2->{
			System.out.println("Enter amount to withdraw");
			int amount=bs.nextInt();
			System.out.println("Confirm your password");
			int confmpwd=bs.nextInt();
			int availamount=dao.withdraw(amount, confmpwd, res);
			if(availamount==-1) {
				System.out.println("Low Balance");
			}
			else if(availamount==0) {
				System.out.println("Incorrect password");
			}
			else {
				System.out.println("Withdraw successful \n Available Amount is :"+availamount);
			}
	}
case 3->{
	System.out.println("Enter current password");
	int currentpwd=bs.nextInt();
	System.out.println("Enter new password");
	int newpwd=bs.nextInt();
	
	int status=dao.changepwd(currentpwd, newpwd, res);
	if(status==1) {
		System.out.println("Password changed...");
	}
	else {
		System.out.println("Something went wrong");
	}
	
}
case 4->{
	System.out.println("Enter password to delete");
	int pass=bs.nextInt();
	int status=dao.deleteAccount(pass,res);
	if(status==1) {
		System.out.println("Your account is deleted\n Good Bye!....");
	}
	else {
		System.out.println("Something went wrong");
	}
	
	
	
	
	
}


}




}

}
}
bs.close();



	}

}
