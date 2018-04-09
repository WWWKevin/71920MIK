package com.offcn.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.demo.BaseDao;
public class PfUsersevice {
	BaseDao dao=new BaseDao();
	public List<Map<String, Object>> queryPfUserList(HttpServletRequest request, HttpServletResponse response){

		String sql="SELECT u_id, u_nickname,u_state,u_province,u_city,u_district FROM u_idle_user";
		
		List<Map<String, Object>> list =new BaseDao().executeQuery(sql);
		return list ;
	}
}
