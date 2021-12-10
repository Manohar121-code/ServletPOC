package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PutSession")
public class PutSession extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		String name = req.getParameter("name");
		String company = req.getParameter("company");

		HttpSession session = req.getSession(true);
		session.setAttribute("name", name);
		session.setAttribute("company", company);

		res.setContentType("text/html");
		PrintWriter pt = res.getWriter();
		pt.println("<h1>" + "Details set to Session Successfully" + "</h1>");
	}

}
