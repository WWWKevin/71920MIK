package com.offcn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.demo.BaseDao;
@WebServlet(urlPatterns="/UStateservlet")
public class UStateservlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String uid=request.getParameter("uid");
    	String sql="UPDATE  u_idle_user SET u_state=IF(u_state='正常','锁定','正常') WHERE u_id='"+uid+"'";
    	
    	int n=new BaseDao().executeUpdate(sql);
    	
    	if(n>0){
    		System.out.println("123");
    		request.getRequestDispatcher("PfUserServlet").forward(request, response);
    	}else{
    		System.out.println("345");
    	}
    }
}
