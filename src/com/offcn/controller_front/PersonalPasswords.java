package com.offcn.controller_front;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.demo.BaseDao;

@WebServlet(urlPatterns="/PersonalPasswords")
public class PersonalPasswords extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String pwd=request.getParameter("pwd");
	   String sql1="SELECT * FROM u_idle_user";
   	   Map<String, Object> map = new BaseDao().executeQuery(sql1).get(0);
   	   request.getSession().setAttribute("map",map);
	   //Map<String, Object> map = (Map<String,Object>)request.getSession().getAttribute("map");
	   String phonenum=map.get("u_phonenum")+"";
	   String sql="UPDATE u_idle_user SET u_password='"+pwd+"' WHERE u_phonenum='"+phonenum+"'";
	   
	   int n=new BaseDao().executeUpdate(sql);
	   
	   if(n>0){
		   response.getWriter().write("ok");
	   }else{
		   
		   response.getWriter().write("error");
	   }
}
}
