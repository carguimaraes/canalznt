package com.digicastservices.canalznt.webapi.seguranca;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class WebApiAssociadoCadastroSeguranca implements Filter
{
	 public final String HEADER_SECURITY_TOKEN = "X-CustomToken"; 
	
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException 
	{ 
		
		 String token =((HttpServletRequest) req).getHeader(HEADER_SECURITY_TOKEN);
		
		  if(!token.equals("GMA-1967"))
		  {
			  ((HttpServletResponse) res).sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
		  }
		  else
		  {
			  chain.doFilter(req, res);  	  
		  }
		  
		 
		
	 
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	} 
}