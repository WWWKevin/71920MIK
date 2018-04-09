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


@WebServlet(urlPatterns="/ElectronicsIdLike")
public class ElectronicsIdLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");

		String sql="SELECT id,idleimg,NAME,original_price,amount,transfer_price FROM u_idle_info WHERE fk_idletype LIKE '%"+id+"%';";
		
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		request.setAttribute("list", list);
		request.getRequestDispatcher("front/Electronicslike.jsp").forward(request, response);

	}
}
