package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register-servlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public registerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println(" Data iiiiiiinsert");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		/*try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbnew", "root", "");
		PreparedStatement stmt = con.prepareStatement("insert into user values (?,?,?,?)");
		stmt.setString(1, "id");
		stmt.setString(2, "name");
		stmt.setString(3, "email");
		stmt.setString(4, "password");
		stmt.executeUpdate();

		con.close();
	} catch (Exception e) {
		System.out.println("OOps Exception !!!");
	}*/		
	 User user=new User();
     user.setEmail(email);
     user.setId(id);
     user.setName(name);
     user.setPassword(password);
     JDBCRegisterService.connectionMethod(user);
     response.sendRedirect("Login.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
