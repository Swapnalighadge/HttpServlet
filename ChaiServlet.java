package com.chaiwala.webApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ChaiServlet extends HttpServlet{
	@Override
protected void doPost (HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException,IOException{
	
	String ChaiBrand =arg0.getParameter("br");
	String ChaiQty =arg0.getParameter("qt");
	String ChaiPrice =arg0.getParameter("pr");
	
//	System.out.println(ChaiBrand +" is from "+ChaiQty);
	
	//getWriter() --> ServletResponse
	//ref --->printWriter
	
//	PrintWriter out =   arg1.getWriter();
//	 out.println("<html>"
//			 +"<body bgcolor='crimson'>"
//			 +"<h1>User details:->"+ChaiBrand +ChaiQty+ChaiPrice+
//			 "</h1></body></html>");
//	 
//jdbc code
	 try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
		    
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=123");
			System.out.println("Connection established...");
			
			PreparedStatement pstmt =con.prepareStatement("insert into chai.info values(?,?,?)");
//			System.out.println("Platform created to execute sql query");
			pstmt.setString(1,ChaiBrand);
			pstmt.setString(2, ChaiQty);
			pstmt.setString(3, ChaiPrice);
			pstmt.executeUpdate();
	 }
	 catch (Exception e) {
		 e.printStackTrace();
	 }
	
}

}
