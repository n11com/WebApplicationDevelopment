package com.yusuf.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/annotation", name = "annotation-servlet")
public class AnnotationServlet extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		
		res.getWriter().println("<h1>Hello World!</h1>");
	}
}