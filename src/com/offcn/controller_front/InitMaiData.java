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

import net.sf.json.JSONArray;


@WebServlet(urlPatterns="/InitMaiData")
public class InitMaiData extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	   String u_id = request.getParameter("u_id");
	   String sql_chushouzhong="SELECT COUNT(1) AS 'chushouzhong' FROM u_idle_info WHERE transfer_state='未交易' AND fk_fisher='"+u_id+"'";
	   String sql_chengjiaojilu="SELECT COUNT(1) AS 'chengjiaojilu' FROM u_idle_info WHERE transfer_state='已交易' AND fk_fisher='"+u_id+"'";
	   BaseDao a=new BaseDao();
	   List<Map<String, Object>> list_chushouzhong = a.executeQuery(sql_chushouzhong);
	   List<Map<String, Object>> list_chengjiaojilu = a.executeQuery(sql_chengjiaojilu);
	   String chushouzhong = list_chushouzhong.get(0).get("chushouzhong")+"";
	   String chengjiaojilu =list_chengjiaojilu.get(0).get("chengjiaojilu")+"";
	   
	   Map<String, String> initmap = new HashMap<String, String>();
	   initmap.put("chushouzhong", chushouzhong);
	   initmap.put("chengjiaojilu", chengjiaojilu);
	   
	   String str=JSONArray.fromObject(initmap).toString();
	   response.getWriter().write(str);
	   
}
}
