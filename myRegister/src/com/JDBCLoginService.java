package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCLoginService 
{
	public static Connection connectionMethod() throws ClassNotFoundException, SQLException
	{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbnew?serverTimezone=UTC", "root", "");
		
		return con;
		
		
		
     }
}
