package com.offcn.controller_front;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.demo.BaseDao;

@WebServlet(urlPatterns="/PhoneErshou")
@MultipartConfig
public class PhoneErshou extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	   String sql="SELECT id,name,unit,idleimg,presentation,transfer_price FROM u_idle_info";
	   
	   List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
	   
	   request.setAttribute("list", list);
	   request.getRequestDispatcher("front/PhoneErshou.jsp").forward(request, response);

}
}
