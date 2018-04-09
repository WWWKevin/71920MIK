<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">个人中心</a></li>
		<li><a href="#">修改密码</a></li>
	</ul>
</div>

<form action="">
	<div class="formbody">
		<div class="formtitle"><span>设置密码</span></div>
		<ul class="forminfo">
			<li>
				<label>原始密码</label>
				<input id="oripwd" onblur="checkOripwd()" name="" type="password" class="dfinput" />
				<i id="m1"></i>
			</li>
			<li>
				<label>新密码</label>
				<input name="" type="password" class="dfinput" />
				<i></i>
			</li>
			<li>
				<label>确认密码</label>
				<input name="" type="password" class="dfinput" />
				<i></i>
			</li>
			
			
			<li>
				<label>&nbsp;</label>
				<input name="" type="submit" class="btn" value="确认保存"/>
			</li>
		</ul>
	</div>
</form>

<script src="<%=basePath %>js/upload.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jQuery/jquery.js"></script>

<script>
	function checkOripwd(){
		var oripwd = $('#oripwd').val();
		$.ajax({
			url:'CheckOriPwd',
			data:'oripwd='+oripwd+'',
			success:function(data){
				$('#m1').html(data);
			},
			error:function(){
				alert('请求失败')
			}
		});
	}
</script>

</body>
</html>
	