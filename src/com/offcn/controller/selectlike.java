package com.offcn.controller;

import java.util.List;
import java.util.Map;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.Selectservice;;
@WebServlet("/selectlike")
public class selectlike extends HttpServlet {
	Selectservice n=new Selectservice(); 
	private static final long serialVersionUID = 1L;
	@Override
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,Object>> list = n.selectlikes(request, response);
		request.setAttribute("list", list);
		request.getRequestDispatcher("module_idle/table.jsp").forward(request, response);
	}
}
