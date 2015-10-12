package com.yusuf.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

/*
 * It is possible to define a web servlet using @WebServlet annotation
 * instead of declaring it in web.xml file. They have the same purpose.
 */
@WebServlet(value = "/annotation", name = "annotation-servlet")
public class AnnotationServlet extends GenericServlet {

    /*
     * Since the servlet extends GenericServlet, it'll have to override service method.
     *
     * If you want to override HTTP method specific methods (like doGet, doPost),
     * you should extend the class from HTTPServlet
     */
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
        // this method sets the response content type to be an HTML, so that browser can display the content
		res.setContentType("text/html");

		res.getWriter().println("<h1>Hello World!</h1>");
	}
}