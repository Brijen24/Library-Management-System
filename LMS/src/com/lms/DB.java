package com.lms;
import java.sql.*;

public class DB {
	
	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","mjtbniinV1#");
			
		}catch(Exception e){System.out.println(e);}
		return con;
	}

}