package com.offcn.controller_front;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.demo.BaseDao;

@WebServlet(urlPatterns="/ConfigOrder")
public class ConfigOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	   String id=request.getParameter("id");
	   String sql="SELECT *FROM u_idle_info WHERE id='"+id+"'";
	   Map<String, Object> map = new BaseDao().executeQuery(sql).get(0);
	   
	   request.setAttribute("imap", map);
	   request.getRequestDispatcher("front/BuyOrder.jsp").forward(request, response);
}
}
