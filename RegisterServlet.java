package com.jlcindia.servlets;


import java.io.IOException; 
import java.io.PrintWriter; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
@WebServlet(name="register",urlPatterns= {"/myregister.jlc"})
public class RegisterServlet  extends HttpServlet{ 

public void service(HttpServletRequest request, HttpServletResponse response) throws 
IOException,ServletException{ 

//1.Collect Input Data 
String fname = request.getParameter("fname"); 
String email= request.getParameter("email"); 
String phone= request.getParameter("phone"); 
String gender= request.getParameter("gender"); 
String timings= request.getParameter("timings"); 
String remarks = request.getParameter("remarks"); 
String mycourses[]= request.getParameterValues("mycourses"); 
// 2. Do Processing
System.out.println(fname);
System.out.println(email);
System.out.println(phone);
System.out.println(gender);
System.out.println(timings);
System.out.println(remarks);
for(String cou:mycourses) {
System.out.println(cou);
}
//3.Send Response 
response.setContentType("text/html"); 
PrintWriter out=response.getWriter(); 
out.print("<h3>Your registration is completed sucessfully<h3>" ); 
out.print("<h3>with the following info<h3>" ); 
out.print("<table>" ); 
out.print("<tr>" );
out.print("<td> Full Name</td>" );
out.print("<td>"+fname+"</td>" );
out.print("</tr>" ); 
out.print("<tr>" );
out.print("<td> Email</td>" );
out.print("<td>"+email+"</td>" );
out.print("</tr>" ); 
out.print("<tr>" );
out.print("<td>Phone </td>" );
out.print("<td>"+phone+"</td>" );
out.print("</tr>" ); 
out.print("<tr>" );
out.print("<td> Gender</td>" );
out.print("<td>"+gender+"</td>" );
out.print("</tr>" ); 
out.print("<tr>" );
out.print("<td> Timings</td>" );
out.print("<td>"+timings+"</td>" );
out.print("</tr>" ); 
out.print("<tr>" );
out.print("<td>Remarks</td>" );
out.print("<td>"+remarks+"</td>" );
out.print("</tr>" ); 
out.print("<tr>" );
out.print("<td>courses </td>" );
out.print("<td>");
for(String cou:mycourses) {
out.print(cou+" <br/> " );
}
out.print("</td>");
out.print("</tr>" ); 
out.print("</table>" ); 

} 
} 
