package com.offcn.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.demo.BaseDao;


public class Selectservice {
	//BaseDao dao=new BaseDao();
	public List<Map<String,Object>> queryGoodsList(){
		String sql = "SELECT  * FROM u_idle_info";
		
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		
		
		return list;
	}
	public List<Map<String,Object>> selectlikes(HttpServletRequest request, HttpServletResponse response){
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name=request.getParameter("name");
		
		String sql = "SELECT NAME,presentation,unit ,amount,location,purchasing_date FROM u_idle_info WHERE name LIKE '%"+name+"%'";
		
		List<Map<String, Object>> list=new BaseDao().executeQuery(sql);
		//List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
	
		return list;
	}
	public List<Map<String,Object>> selectlikee(HttpServletRequest request, HttpServletResponse response){
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String namee=request.getParameter("namee");
		//String u_province=request.getParameter("u_province");
		String sql="SELECT u_id,u_nickname,u_state,u_province,u_city,u_district FROM u_idle_user WHERE u_state LIKE '%"+namee+"%' OR u_province LIKE '%"+namee+"%'";
		List<Map<String,Object>> list=new BaseDao().executeQuery(sql);
		
		return list;
	}
	public List<Map<String,Object>> statistics(HttpServletRequest request, HttpServletResponse response){
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String namee=request.getParameter("namee");
		//String u_province=request.getParameter("u_province");
		String sql="SELECT u_province ,COUNT(u_province) AS amount FROM u_idle_user GROUP BY u_province";
		
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		return list;
		
	}
}

