package com.offcn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.Loginservice;
@WebServlet(urlPatterns="/Exitservlet")
public class Exitservlet extends HttpServlet {
	Loginservice kk=new Loginservice();
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		kk.exitLogin(request, response);
	}
    

}
