package com.example.helloservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.helloservlet.services.HelloNameService;
import com.google.inject.Inject;
import com.google.inject.Singleton;


/**
 * Servlet implementation class HelloWorldServlet
 */
// Singleton is required by google Guice
@Singleton
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private HelloNameService helloNameService;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloWorldServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = helloNameService.processName(req.getParameter("name"));
		req.setAttribute("user", name);
		req.getRequestDispatcher("response.jsp").forward(req, resp);
	}

}
