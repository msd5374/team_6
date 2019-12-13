package com;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.User;

public class JDBCRegisterService
{
	public static void connectionMethod(User user){
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbnew?serverTimezone=UTC", "root", "");
		PreparedStatement stmt = con.prepareStatement("insert into user values (?,?,?,?)");
		stmt.setString(1, user.getId());
		stmt.setString(2, user.getName());
		stmt.setString(3, user.getEmail());
		stmt.setString(4, user.getPassword());
		stmt.executeUpdate();

		con.close();
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
}
}
