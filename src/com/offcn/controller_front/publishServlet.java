package com.offcn.controller_front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.controller_frontService.publishservice;
@WebServlet(urlPatterns="/publishServlet")
@MultipartConfig
public class publishServlet extends HttpServlet {
	publishservice a=new publishservice();
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int n=a.Publishser(request, response);
		if(n>0){
			System.out.println("添加成功");
			request.getRequestDispatcher("front/index.jsp").forward(request, response);

		}else{
			System.out.println("添加失败");
		}
	}
}
