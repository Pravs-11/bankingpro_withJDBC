package com.bankingpro;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest{
	bankingdao b1=new bankingdao();
	//test case to test login method
	//@Disabled annotation used to disable the test case
	//@DispalyName("dfdsds") used to change the method name as you want
	@Disabled
	@Test
	@DisplayName("Pravallika")
	public void testlogin() throws Exception {
		b1.dbconnection();
		int exp=1;
		int res=b1.login("Pravallika", 12345);
		assertEquals(exp,res);
	}
	//test case to test deposit method
	@Disabled
	@Test
	public void testdeposit() throws Exception {
		b1.dbconnection();
		int exp=20000;
		int res=b1.deposit(20000,1);
		assertEquals(exp,res);
	}
	//test case to test withdraw method
	@Disabled
	@Test
	public void testwithdraw() throws Exception {
		b1.dbconnection();
		int exp=100000;
		int res=b1.withdraw(80000,12345,1);
		assertEquals(exp,res);
	}
	//test case to test changepassword method
	@Disabled
	@Test
	public void testchangepwd() throws Exception {
		b1.dbconnection();
		int exp=1;
		int res=b1.changepwd(12345,54321,1);
		assertEquals(exp,res);
	}
	//test case to test delete account method
	@Disabled
	@Test
	public void testdelaccount() throws Exception {
		b1.dbconnection();
		int exp=1;
		int res=b1.deleteAccount(54321,1);
		assertEquals(exp,res);
	}
	//test case to test register method
	@Test
	public void testregister() throws Exception {
		customer c1=new customer();
		c1.cusid=3;
		c1.cusname="cus3";
		c1.cuspin=2021;
		c1.cusamount=5000;
		b1.dbconnection();
		int exp=1;
		int res=b1.registercustomer(c1);
		assertEquals(exp,res);
		
	}
}