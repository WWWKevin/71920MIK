package com.offcn.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.offcn.demo.BaseDao;
public class Deleteservice {
	BaseDao dao = new BaseDao();
public int deleteGoodsById(HttpServletRequest request, HttpServletResponse response){
		
		String id = request.getParameter("id");
		String sql = "DELETE FROM u_idle_info WHERE id = "+id+"";
		
		int n = dao.executeUpdate(sql);
		
		return n;
	}
}
