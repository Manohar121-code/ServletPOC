package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetEmployees")
public class GetEmployees extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		DBOps dbOps = new DBOps();
		List<Employee> employees = dbOps.getEmployees();
		
		res.setContentType("text/html");
		PrintWriter pt = res.getWriter();
		pt.println("<h1>"+ "Employee List" +"</h1>");
		for (Employee emp : employees) {
			pt.println("<h2>"+ emp + "</h2>");
		}
	}
	
}
