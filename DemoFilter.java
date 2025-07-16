package com.jlcindia.servlets; 
 
import java.io.IOException; 
import javax.servlet.Filter; 
import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig; 
import javax.servlet.ServletContext; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.annotation.WebFilter; 
import javax.servlet.annotation.WebInitParam; 
 
@WebFilter( 
  filterName="mydemoServlet", 
  urlPatterns = "/mydemo.jlc", 
  initParams = {  
  @WebInitParam(name="phone",value = "55555"), 
  }
  )


public class DemoFilter implements Filter { 
 
FilterConfig filterConfig = null; 
 
public void init(FilterConfig filterConfig) throws ServletException { 
System.out.println("DemoFilter - init()"); 
this.filterConfig = filterConfig; 
} 
 
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
throws IOException, ServletException { 
System.out.println("DemoFilter - doFilter() - PRE-begin"); 
 
String name = request.getParameter("name"); 
System.out.println("1. Req.P  -  " + name); 
 
String phone = filterConfig.getInitParameter("phone"); 
System.out.println("2. F.Config.P - " + phone); 
 
ServletContext context = filterConfig.getServletContext(); 
String city = context.getInitParameter("City"); 
System.out.println("3. S.Context.P -  " + city); 
 
System.out.println("DemoFilter - doFilter() - PRE-end"); 
 
chain.doFilter(request, response); // Invokes Next Component 
 
System.out.println("DemoFilter - doFilter() - No Post Work"); 
} 
 
public void destroy() { 
System.out.println("DemoFilter - destroy()"); 
} 
}
