package com.offcn.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.Selectservice;
@WebServlet(urlPatterns="/selectlikes")
public class selectlikes extends HttpServlet {
	Selectservice a=new Selectservice();
	
	private static final long serialVersionUID = 1L;
    
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	List<Map<String, Object>> list=a.selectlikee(request, response);
	
	request.setAttribute("list", list);
	request.getRequestDispatcher("module_pfuser/pfuserlist.jsp").forward(request, response);
}
}
