package com.jlcindia.servlets; 

import java.io.IOException; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
@WebServlet(name = "mydemo", urlPatterns = "/mydemo.jlc") 
public class DemoServlet extends HttpServlet { 

public void service(HttpServletRequest request, HttpServletResponse response) throws 
IOException, ServletException { 
System.out.println("----DemoServlet---"); 

HttpSession session = request.getSession(); 
System.out.println(session.isNew()); 
System.out.println(session.getId()); 

RequestDispatcher rd = request.getRequestDispatcher("show.html"); 
rd.forward(request, response); 
} 
} 
 
 
 
 
 
