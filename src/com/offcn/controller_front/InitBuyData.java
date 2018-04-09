package com.offcn.controller_front;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.demo.BaseDao;
import com.sun.xml.internal.messaging.saaj.util.Base64;

import net.sf.json.JSONArray;

@WebServlet(urlPatterns="/InitBuyData")
public class InitBuyData extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id =request.getParameter("u_id");
		
		String sql_goumaijilu="SELECT COUNT(1) AS 'goumaijilu' FROM u_idle_info WHERE transfer_state='已交易' AND fk_fisher='"+u_id+"'";
		String sql_chushouzhong="SELECT COUNT(1) AS 'chushouzhong' FROM u_idle_info WHERE transfer_mode='线上交易' AND fk_fisher='"+u_id+"'";
	
		BaseDao dao=new BaseDao();
		
		List<Map<String, Object>> list_goumaijilu = dao.executeQuery(sql_goumaijilu);
		List<Map<String, Object>> list_chushouzhong=dao.executeQuery(sql_chushouzhong);
		
		String goumaijilu=list_goumaijilu.get(0).get("goumaijilu")+"";
		String chushouzhong=list_chushouzhong.get(0).get("chushouzhong")+"";
		
		Map<String, String> amap = new HashMap<String, String>();
		amap.put("goumaijilu", goumaijilu);
		amap.put("chushouzhong", chushouzhong);
		
		String str1=JSONArray.fromObject(amap).toString();
		response.getWriter().write(str1);
	}
	
}
