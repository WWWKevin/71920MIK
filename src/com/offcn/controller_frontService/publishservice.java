package com.offcn.controller_frontService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offcn.demo.BaseDao;

public class publishservice {
	
	public int Publishser(HttpServletRequest request, HttpServletResponse response){
		
		String name=request.getParameter("name");
		String presentation =request.getParameter("presentation");
		String fileName = saveImg(request, response);

		String sql="INSERT INTO u_idle_info(name,presentation,idleimg) VALUES ('"+name+"','"+presentation+"','"+fileName+"')";
		int n=new BaseDao().executeUpdate(sql);
		return n;
	}

	public String saveImg(HttpServletRequest request, HttpServletResponse response){
		Part part = null;
		try {
			//1.获取用户上传图片对应的part对象
			part = request.getPart("idleimg");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		//2.获取当前时间
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
		String str = sf.format(date);
		
		//3.获取用户上传的图片的后缀
		String cd = part.getHeader("Content-Disposition");
		//form-data; name="idleimg"; filename="20171108083623.jpg"
		String houzui = cd.substring(cd.lastIndexOf("."), cd.length()-1);
		String fileName = str+houzui;
		
		//4.将图片保存,利用生成的文件名
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

