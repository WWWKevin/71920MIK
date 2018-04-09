package com.offcn.controller_front;

import java.io.IOException;
import java.util.Map;

import javax.crypto.Mac;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.demo.BaseDao;


@WebServlet(urlPatterns="/Checkonpwdx")
public class Checkonpwdx extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
    	
    	String oripwd=request.getParameter("oripwd");
    	String sql="SELECT * FROM u_idle_user";
    	Map<String, Object> map = new BaseDao().executeQuery(sql).get(0);
    	request.getSession().setAttribute("map",map);
    	
    	String password =map.get("u_password")+"";
    	String msg="";
    	if(oripwd.equals(password)){
    		msg="ok";
    	}else{
    		msg="error";
    	}
    	
    		response.getWriter().write(msg);
    }
}
