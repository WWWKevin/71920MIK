package com.offcn.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.Updateservice;
import com.offcn.demo.BaseDao; 
@WebServlet(urlPatterns="/updateservlet")
public class updateservlet extends HttpServlet {
	
	Updateservice y=new Updateservice();
	
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int n=y.updateuser(request, response);
    	if(n>0){
    		String account=request.getParameter("account");
    		String sql="SELECT * FROM u_sys_admin WHERE account = '"+account+"'";
    		 Map<String, Object> map=new BaseDao().executeQuery(sql).get(0); 
    		 request.getSession().setAttribute("map", map);
    	}
    }
}
