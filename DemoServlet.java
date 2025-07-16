package com.jlcindia.servlets; 
 
import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.ServletConfig; 
import javax.servlet.ServletContext; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebInitParam; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
@WebServlet( 
  name="mydemoServlet", 
  urlPatterns = "/mydemo.jlc", 
  loadOnStartup = 1, 
  initParams = {  
       @WebInitParam(name="email",value = "vas@jlc.com"), 
   } 
  ) 
public class DemoServlet  extends HttpServlet{ 
 
ServletConfig servletConfig=null; 
 
public void init(ServletConfig servletConfig) throws ServletException { 
System.out.println("DemoServlet - init()"); 
this.servletConfig=servletConfig; 
} 
 
public void service(HttpServletRequest request, HttpServletResponse response) throws 
IOException,ServletException{ 
System.out.println("DemoServlet - service() - begin"); 
 
String name = request.getParameter("name"); 
System.out.println("1. Req.P  -  " + name); 
 
String email= servletConfig.getInitParameter("email"); 
System.out.println("2. F.Config.P - " + email); 
 
 
ServletContext context = servletConfig.getServletContext(); 
String city= context.getInitParameter("City"); 
System.out.println("3. S.Context.P -  " + city); 
 
PrintWriter out=response.getWriter(); 
response.setContentType("text/html"); 
 
out.print("<h1> Check Console output </h1>"); 
  
 
System.out.println("DemoServlet - service() - end"); 
} 
 
public void destroy() { 
System.out.println("DemoServlet - destroy()"); 
} 
} 
 

