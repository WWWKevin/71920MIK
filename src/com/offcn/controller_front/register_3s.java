package com.offcn.controller_front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.demo.*;


@WebServlet(urlPatterns="/register_3s")
public class register_3s extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String pwd=request.getParameter("pwd");
    	String phone=request.getSession().getAttribute("phone")+"";
    	
    	String sql="INSERT INTO u_idle_user(u_phonenum,u_password) VALUES ('"+phone+"','"+pwd+"')";
    	int n=new BaseDao().executeUpdate(sql);
    	if(n>0){
    		request.getRequestDispatcher("front/index.jsp").forward(request, response);
    	}
    }
}
