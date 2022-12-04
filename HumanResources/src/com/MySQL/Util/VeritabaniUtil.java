package com.MySQL.Util;
import java.sql.*;

public class VeritabaniUtil {
	static Connection conn=null;
 
	
	
	public static Connection baglan()
	{
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/ik_veritabani","root","");
			return conn;
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
		
		
		
	}	
	
	
}
