package com.jlcindia.servlets; 
 
import java.io.IOException; 
import javax.servlet.*; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.*; 

 
@WebServlet(name="login",urlPatterns = {"/mylogin.jlc","/login.jlc"}) 
public class LoginServlet  extends HttpServlet{ 
 
public void service(HttpServletRequest request, HttpServletResponse response) throws 
IOException,ServletException{ 
 
//1.Collect Input Data 
String un = request.getParameter("myusername"); 
String pw = request.getParameter("mypassword"); 
String rem = request.getParameter("remember"); 
System.out.println(rem); 
 
//2.Do Processing and Prepare the Response 
String page=""; 
if(un.equals(pw)) { 
//Success 
page="home.jsp"; 
request.setAttribute("UN", un); 
if(rem!=null) { 
if(rem.equals("Yes")) { 
Cookie ck1=new Cookie("UNAME",un); 
ck1.setMaxAge(365*24*60); 
response.addCookie(ck1); 
 
Cookie ck2=new Cookie("PWORD",pw); 
ck2.setMaxAge(365*24*60); 
response.addCookie(ck2); 
} 
} 
}else { 
page="login.jsp"; 
String msg= " <h3>Login Failed - Try again</h3>"; 
request.setAttribute("ErrMsg", msg); 
} 
//3.Forward 
RequestDispatcher rd=request.getRequestDispatcher(page); 
rd.forward(request, response); 
} 
} 
