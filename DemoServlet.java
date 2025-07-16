 
package com.jlcindia.servlets; 
 
import java.io.IOException; 
import java.io.PrintWriter; 
 
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
System.out.println("1."+"----DemoServlet---"); 
 
HttpSession session = request.getSession(); 
System.out.println("2."+session.getId()); 
 
boolean b1=request.isRequestedSessionIdFromCookie(); 
System.out.println("3."+b1); 
boolean b2=request.isRequestedSessionIdFromURL(); 
System.out.println("4."+b2); 
 
String page=""; 
if(session.isNew()) { 
page="demo.jsp"; 
}else { 
page="home.jsp"; 
} 
 
System.out.println("5."+page); 
page=response.encodeRedirectURL(page); 
System.out.println("6."+page); 
 
 
RequestDispatcher rd= request.getRequestDispatcher(page); 
rd.forward(request, response); 
} 
} 
