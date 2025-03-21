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
		 name="hai", 
		 urlPatterns = "/hai.jlc", 
		 loadOnStartup=2,
		 initParams = { 
				 @WebInitParam(name="email",value="hai@hai.com") 
		 } 
		  ) 

public class HaiServlet  extends HttpServlet{ 
 
static { 
System.out.println("HaiServlet - S.B"); 
} 
public HaiServlet() { 
System.out.println("HaiServlet - D.C"); 
} 
 
public void init(ServletConfig sconfig) throws ServletException { 
super.init(sconfig); 
System.out.println("HaiServlet - init()"); 
} 
 
public void service(HttpServletRequest request, HttpServletResponse response) throws 
IOException,ServletException{ 
System.out.println("HaiServlet - service()"); 
 
//1.Collect Request Params 
String fname = request.getParameter("fname"); 
String phone = request.getParameter("phone"); //null 
 
//2.Collect Config Params 
ServletConfig sconfig= getServletConfig(); 
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
out.print("<td> Phone </td>"); 
out.print("<td> "+ phone +" </td>"); 
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
System.out.println("HaiServlet - destroy()"); 
} 
} 
 
 
