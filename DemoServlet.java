package com.jlcindia.servlets; 
 
import java.io.*; 
import java.util.*; 
 
import javax.servlet.http.*; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 

  
 
@WebServlet(name="demo",urlPatterns = {"/mydemo.jlc"}) 
public class DemoServlet  extends HttpServlet{ 
 
public void service(HttpServletRequest request, HttpServletResponse response) throws 
IOException,ServletException{ 
 
//1.Request Parameters 
System.out.println("-----1.Request Parameters-----"); 
Enumeration<String>  enms1 = request.getParameterNames(); 
List<String> paramNames = Collections.list(enms1); 
 
for(String paramName: paramNames ) { 
String paramValue =request.getParameter(paramName); 
System.out.println(paramName+"-----\t"+paramValue); 
} 
 
//2.Request Headers 
System.out.println("-----2.Request Headers-----"); 
Enumeration<String>  enms2 = request.getHeaderNames(); 
List<String> headerNames = Collections.list(enms2); 
 
for(String headerName : headerNames ) { 
String headerValue =request.getHeader(headerName); 
System.out.println(headerName+"-----\t"+headerValue); 
} 
 
//2.Request Headers 
System.out.println("-----2.Request Headers-----"); 
String hvalue =request.getHeader("referer"); 
System.out.println(hvalue); 
hvalue =request.getHeader("accept-encoding"); 
System.out.println(hvalue); 
hvalue =request.getHeader("cookie"); 
System.out.println(hvalue); 
 
 
 
 
 
 
 
 
//3.Request Cookies 
System.out.println("-----3.Request Cookies-----"); 
Cookie cks[] = request.getCookies(); 
if(cks!=null) { 
for(Cookie ck:cks) { 
System.out.println(ck.getName()+"-------"+ck.getValue()); 
} 
} 
 
//4.Other Information 
System.out.println("-----4.Other Information-----"); 
System.out.println(" getRequestURI : "+request.getRequestURI()); //Imp 
System.out.println("Http Method : "+request.getMethod()); 
System.out.println("getLocalAddr : "+request.getLocalAddr()); 
System.out.println(" getLocalAddr: "+request.getLocalAddr()); 
System.out.println(" getRemoteAddr: "+request.getRemoteAddr()); 
System.out.println("getLocale : "+request.getLocale().getLanguage()); 
System.out.println("getAuthType : "+request.getAuthType()); 
System.out.println(" getCharacterEncoding: "+request.getCharacterEncoding()); 
System.out.println(" getContentLength: "+request.getContentLength()); 
System.out.println(" getContentType: "+request.getContentType()); 
System.out.println("getPathInfo : "+request.getPathInfo()); 
System.out.println(" getQueryString: "+request.getQueryString()); 
System.out.println(" getRemoteHost: "+request.getRemoteHost()); 
System.out.println(" getRemoteUser: "+request.getRemoteUser()); 
System.out.println(" getServletPath : "+request.getServletPath()); 
 
response.setContentType("text/html"); 
PrintWriter out= response.getWriter(); 
out.println("<h1> Check the Console for output</h1>"); 
} 
} 
 
