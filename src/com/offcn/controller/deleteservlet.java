package com.offcn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.Deleteservice;;
@WebServlet(urlPatterns="/deleteservlet")
public class deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Deleteservice p=new Deleteservice();
    	int n = p.deleteGoodsById(request, response);
		
		if(n>0){
			System.out.println("É¾³ý³É¹¦");
			request.getRequestDispatcher("selectservlet").forward(request, response);
		}
    }
}
