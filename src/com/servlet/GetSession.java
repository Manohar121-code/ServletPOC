package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetSession")
public class GetSession extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		HttpSession session = req.getSession();
		String name = (String) session.getAttribute("name");
		String company = (String) session.getAttribute("company");
		
		res.setContentType("text/html");
		PrintWriter pt = res.getWriter();
		pt.println("<h1>" + "Name - " + name + " & company - " + company + "</h1>");
	}
	
}
