package com.offcn.controller_frontService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offcn.demo.BaseDao;

public class PhoneErshou {

	public List<Map<String, Object>> PhoneErshous (HttpServletRequest request, HttpServletResponse response){
		
		  String sql="SELECT id,NAME,idleimg,presentation,transfer_price FROM u_idle_info";
		  
		  List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		  
		  return list;
	}
	public String saveImg(HttpServletRequest request, HttpServletResponse response){
		Part part = null;
		try {
			//1.��ȡ�û��ϴ�ͼƬ��Ӧ��part����
			part = request.getPart("idleimg");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		//2.��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
		String str = sf.format(date);
		
		//3.��ȡ�û��ϴ���ͼƬ�ĺ�׺
		String cd = part.getHeader("Content-Disposition");
		//form-data; name="idleimg"; filename="20171108083623.jpg"
		String houzui = cd.substring(cd.lastIndexOf("."), cd.length()-1);
		String fileName = str+houzui;
		
		//4.��ͼƬ����,�������ɵ��ļ���
		try {
			//D:\apache-tomcat-9.0.0.M21\webapps\offcn_idle_sys\idleimg
			String realPath = request.getServletContext().getRealPath("/idleimg")+"\\"+fileName;
			part.write(realPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fileName;
	}
}

