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


@WebServlet(urlPatterns="/xiangqing")
public class xiangqing extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String id=request.getParameter("id");
    	String sql="SELECT*FROM u_idle_info WHERE id="+id+"";
    	Map<String, Object> map=new BaseDao().executeQuery(sql).get(0);
    	request.setAttribute("map", map);
    	request.getRequestDispatcher("front/xiangqing.jsp").forward(request, response);
    }

}
