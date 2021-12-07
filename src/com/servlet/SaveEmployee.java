package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveEmployee")
public class SaveEmployee extends HttpServlet {

	public void init() {
		System.out.println("SaveEmployee initialized successfully");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String name = req.getParameter("name");
		
		String ageStr = req.getParameter("age");
		int age = Integer.parseInt(ageStr);
		
		String salaryStr = req.getParameter("salary");
		double salary = Double.parseDouble(salaryStr);
		
		Employee emp = new Employee(name, age, salary);
		
		DBOps dbOps = new DBOps();
		dbOps.saveEmployee(emp);
		
		res.setContentType("text/html");
		PrintWriter pt = res.getWriter();
		pt.print("<h1>"+ "Employee data inserted successfully" +"</h1>");
	}

	public void destroy() {
		System.out.println("SaveEmployee destroyed successfully");
	}
	
}
