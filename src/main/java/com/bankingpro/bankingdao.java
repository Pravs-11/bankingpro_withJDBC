package com.bankingpro;
//controller which is communicating with db
import java.sql.*;
public class bankingdao {
	Connection con=null;
	//method to get connection with Data base
	public void dbconnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingpro", "root","Pravs@99");	
	}
//Method to register customer to data base
	public int registercustomer(customer c1)throws Exception {
		String query="insert into customer values(?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, c1.cusid);
		pst.setString(2,c1.cusname);
		pst.setInt(3,c1.cuspin);
		pst.setInt(4,c1.cusamount);
		int response=pst.executeUpdate();
	return response;
	}
	//method to login the customer
	public int login(String uname, int pwd)throws Exception{
		String query="select * from customer where cusname='"+uname+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		//checking whether the customer details present or not
		if(rs.next()) {
			//fetching the password from db
			int password=rs.getInt(3);
			
			//matching the password
			if(password==pwd) {
				//login success
				return rs.getInt(1);
			}
			else {
				//password incorrect
				return 0;
			}
		}
		else {
			//unable to fetch the details
			return -1;
		}
	
	}
	public int deposit(int amount, int customerid)throws Exception{
		//fetching user details based on customer id
		String query2="select * from customer where cusid="+customerid;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query2);
		rs.next();
		//extracting account balance
		int bal=rs.getInt(4);
		//updating amount
		amount+=bal;
		//storing updated amount
		String query="update customer set cusamount="+amount+" where cusid="+customerid;
		PreparedStatement pst=con.prepareStatement(query);
		pst.executeUpdate();
		//return updated amount
		return amount;
	}
	

}
