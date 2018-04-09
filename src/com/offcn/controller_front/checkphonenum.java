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


@WebServlet(urlPatterns="/checkphonenum")
public class checkphonenum extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phone=request.getParameter("phone");
		
		String sql="SELECT 1 FROM u_idle_user WHERE u_phonenum='"+phone+"'";
		
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		
		if(list !=null && list.size()>0){
			
			response.getWriter().write("ok");
		}else{
			response.getWriter().write("error");
		}
	}
}
