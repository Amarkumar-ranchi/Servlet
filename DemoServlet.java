package com.jlcindia.servlets;  
import java.io.*; 
import javax.servlet.*; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.Cookie; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 

@WebServlet(name = "mydemo", urlPatterns = "/mydemo.jlc") 
public class DemoServlet extends HttpServlet { 
 
public void service(HttpServletRequest request, HttpServletResponse response) throws 
IOException, ServletException { 
System.out.println("----DemoServlet---"); 
 
Cookie cks[] = request.getCookies(); 
 
if(cks!=null) { 
System.out.println("No. of Cookies : "+cks.length); 
 
for(Cookie mycookie:cks) { 
String cname=mycookie.getName(); 
String cvalue=mycookie.getValue(); 
System.out.println(cname+"\t"+cvalue); 
} 
 
}else { 
System.out.println("ooops No Cookies Found : "); 
} 
HttpSession session = request.getSession(); 
if(session.isNew()) { 
Cookie ck1=new Cookie("myemail","sri@jlc"); 
response.addCookie(ck1); 
 
Cookie ck2=new Cookie("myphone","12345"); 
response.addCookie(ck2); 
ck2.setMaxAge(60);  
}else { 
Cookie ck3=new Cookie("hello","Hello-Guys"); 
response.addCookie(ck3); 
ck3.setMaxAge(0); 
} 
 
PrintWriter out=response.getWriter(); 
out.println("<h1>Check the Console Output</h1>"); 
} 
} 
 
 
 
 
 
