package com.offcn.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.Loginservice;

@WebServlet(urlPatterns="/loginservlet")
public class loginservlet extends HttpServlet {
	
	Loginservice aa=new Loginservice();
	
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
    	Map<String, Object> map = aa.login(request, response);

    	if(map!=null){
    		request.getSession().setAttribute("map", map);	
    		request.getRequestDispatcher("index/index.jsp").forward(request, response);
    	}else{
    		response.sendRedirect("login.jsp");
    	}
    }
}
