package com.offcn.controller_front;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.demo.BaseDao;

@WebServlet(urlPatterns="/PersonalinformationSave")
public class PersonalinformationSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("UTF-8");
	    
		String phonenum	=request.getParameter("phonenum");
		String u_nickname=request.getParameter("u_nickname");
		String u_birthday=request.getParameter("u_birthday");
		String u_province=request.getParameter("u_province");
		String u_city=request.getParameter("u_city");
		String u_district=request.getParameter("u_district");
		
		String sql="UPDATE u_idle_user SET u_nickname='"+u_nickname+"',u_birthday='"+u_birthday+"',u_province='"+u_province+"',u_city='"+u_city+"',u_district='"+u_district+"' WHERE u_phonenum='"+phonenum+"'";
	
		int n = new BaseDao().executeUpdate(sql);
		if(n>0){
			String sql1 = "SELECT * FROM u_idle_user WHERE u_phonenum = "+phonenum+"";
			Map<String, Object> map = new BaseDao().executeQuery(sql1).get(0);
			request.getSession().setAttribute("map",map);
			request.getRequestDispatcher("front/PersonalInformation.jsp").forward(request, response);
		}
   	
}
}
