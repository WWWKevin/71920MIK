package com.offcn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.Netservice;
@WebServlet(urlPatterns="/AddldleServlet")
@MultipartConfig
public class AddldleServlet extends HttpServlet {
	//Netservice netservice=new Netservice();
	//AddldleServlet netservice=new AddldleServlet();
	Netservice ii=new Netservice();
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n=ii.AddldleServlet(request, response);
		
		if(n>0){
			System.out.println("添加成功");
			request.getRequestDispatcher("module_idle/addidle.jsp").forward(request, response);

		}else{
			System.out.println("添加失败");
		}

		
	}
   

}
