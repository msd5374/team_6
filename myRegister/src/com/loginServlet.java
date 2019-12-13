package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{   
		try 
		{ 
		 String name1=request.getParameter("name");
	     String password1=request.getParameter("password");
	     System.out.println("hi");
	    Connection con= JDBCLoginService.connectionMethod();
	    PreparedStatement st=con.prepareStatement("select * from user where id=(?) and password=(?)");
	    st.setString(1, name1);
	    st.setString(2, password1);
	    ResultSet rs=st.executeQuery();
	   // rs.next();
	    if(rs.next() )
	    {
	    	request.getSession().setAttribute("Auth", true);
	    	request.getRequestDispatcher("success.jsp").forward(request, response);
	    }
	    else
	    {
	    	response.sendRedirect("notsuccess.jsp");
	    }
	    
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	     
		/* request.setAttribute("name", name1);
		 request.setAttribute("password", password1);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
