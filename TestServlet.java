package com.jlcindia.servlets; 
 
import java.io.*; 
import java.util.*; 
 
import javax.servlet.http.*; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 

  
 
@WebServlet(name="test",urlPatterns = {"/mytest.jlc"}) 
public class TestServlet  extends HttpServlet{ 	
	
 int count=0;
public void service(HttpServletRequest request, HttpServletResponse response) throws 
IOException,ServletException{ 
 count++;
 System.out.println(count);
 if(count<=10) {
	 response.setHeader("Refresh", "5;mytest.jlc");
 }else {
	 response.setHeader("Refresh","5;https://www.coursecube.com" );
 }

 
response.setContentType("text/html"); 
PrintWriter out= response.getWriter(); 
Date date=new Date();
out.println("<h1> Now:"+date+"</h1>");
out.println("<h1> Couter:"+count+"</h1>"); 
} 
} 
 
