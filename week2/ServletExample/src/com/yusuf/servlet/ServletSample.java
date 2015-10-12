package com.yusuf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * This is the basic servlet template.
 *
 * A servlet should override either GenericServlet or HttpServlet.
  *
  * HttpServlet allows you to setup your servlet according to the HTTP methods that are used
 */
public class ServletSample extends HttpServlet {
	private String message;

    /*
     * This method is called by the servlet container to indicate to a servlet that
     * the servlet is being placed in to service
     */
	public void init() throws ServletException {
		message = "Hello World";
	}

    /*
     * This method is called by the servlet container (via the service method, @see javax.servlet.http.HttpServlet#service)
     * to allow a servlet to handle a GET request.
     */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // this method sets the response content type to be an HTML, so that browser can display the content
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}
}
