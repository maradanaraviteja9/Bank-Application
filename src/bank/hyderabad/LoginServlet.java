package bank.hyderabad;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{


protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
IOException
{
	Connection con=null;
	PreparedStatement ps=null;
	String selectQuery="Select * from boh_customers where email=? and password=?";
	ResultSet rs =null;
	
	resp.setContentType("text/html");
	PrintWriter pw=resp.getWriter();
	
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	con=CustomerDatabas.getConnection();
	
	try {
		
	
	con=CustomerDatabas.getConnection();
	ps=con.prepareStatement(selectQuery);
	ps.setString(1,email);
	ps.setString(2,password);
	
	rs=ps.executeQuery();
	if(rs.next())
	{
		String username =rs.getString(1);
		pw.println("<h2 style='color:green;text-align:center'>Login Success , "
				+ "Welcome "+username+"</h2>");
		pw.println("<h4 style='text-align:right'><a href='home.html'>Logout</a></h4>");
	}
	else
	{
		pw.println("<h2 style='color:red;text-align:center'>Invalid Credentials , <a href='home.html'>Try Again</a></h2>");
	}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	
	
	
	
	
	
	
}
}