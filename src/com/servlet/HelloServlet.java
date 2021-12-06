package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	
//	init
//	service
//	destroy

	public void init() {
		System.out.println("HelloServlet initialized successfully");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter pt = res.getWriter();
		pt.print("Hello J2EE & Servlet");
	}
	
	public void destroy() {
		System.out.println("HelloServlet destroyed successfully");
	}
	
}
