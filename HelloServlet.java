package com.jlcindia.servlets; 
 
import java.io.IOException; 
import java.io.PrintWriter; 
 
import javax.servlet.ServletConfig; 
import javax.servlet.ServletContext; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
@WebServlet( 
		 name="hello", 
		 urlPatterns = "/hello.jlc", 
				 loadOnStartup=1,
		 initParams = { 
				 @WebInitParam(name="email",value="hello@hello.com") 
		 } 
		  ) 
		
public class HelloServlet  extends HttpServlet{ 
 
ServletConfig sconfig=null; 
static { 
System.out.println("HelloServlet - S.B"); 
} 
public HelloServlet() { 
System.out.println("HelloServlet - D.C"); 
} 
public void init(ServletConfig sconfig) { 
System.out.println("HelloServlet - init()"); 
this.sconfig=sconfig; 
} 
 
public void service(HttpServletRequest request, HttpServletResponse response) throws 
IOException,ServletException{ 
System.out.println("HelloServlet - service()"); 
 
//1.Collect Request Params 
String fname = request.getParameter("fname"); 
String phone = request.getParameter("phone"); //null 
 
//2.Collect Config Params 
String email= sconfig.getInitParameter("email"); 
 
//3.Collect Context Params 
ServletContext scontext=sconfig.getServletContext(); 
String web = scontext.getInitParameter("website"); 
 

 
 
//4.Do Processing 
System.out.println(fname); 
System.out.println(phone); 
System.out.println(email); 
System.out.println(web); 
 
//5.Send Response 
response.setContentType("text/html"); 
PrintWriter out=response.getWriter(); 
out.print("<h3> <u>1.Request Parameters </u> <h3>"); 
out.print("<table>"); 
out.print("<tr>"); 
out.print("<td> Full Name </td>"); 
out.print("<td> "+ fname+" </td>"); 
out.print("</tr>"); 
out.print("</table>"); 
 
out.print("<h3> <u>2.Config Parameters </u> <h3>"); 
out.print("<table>"); 
out.print("<tr>"); 
out.print("<td> Email</td>"); 
out.print("<td> "+ email+" </td>"); 
out.print("</tr>"); 
out.print("</table>"); 
 
out.print("<h3> <u>3.Context Parameters </u> <h3>"); 
out.print("<table>"); 
out.print("<tr>"); 
out.print("<td> Website </td>"); 
out.print("<td> "+ web+" </td>"); 
out.print("</tr>"); 
out.print("</table>"); 
} 
 
public void destroy() { 
System.out.println("HelloServlet - destroy()"); 
} 
} 