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
System.out.println("Enetr Customer name");
String cname=bs.nextLine();
System.out.println("Enter cus id");
int cid=bs.nextInt();
System.out.println("Enter cus pin");
int cpin=bs.nextInt();
System.out.println("Enter cus amount");
int cbal=bs.nextInt();
c1.cusid=cid;
c1.cusname=cname;
c1.cuspin=cpin;
c1.cusamount=cbal;
dao.dbconnection();
int res =dao.registercustomer(c1);
if(res==1) {
	System.out.println("acc success");
}
else {
	System.out.println("wrong");
}
bs.close();
	}

}
