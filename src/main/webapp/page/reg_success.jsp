<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="/Vote/"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="page/css/style.css" />
</head>
<body>
<div id="header" class="wrap">
	<img src="page/images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="search">
		<form method="get" action="index.html">
			<input type="text" name="keywords" class="input-text" /><input type="submit" name="submit" class="input-button" value="" />
		</form>
	</div>
</div>
<div id="message" class="box">
	<h2>提示信息</h2>
	<div class="content">
		<p>恭喜：注册成功！<a href="page/index.jsp">进入投票首页&gt;&gt;</a></p>
	</div>
</div>
<div id="footer" class="wrap">
	Wild &copy; 版权所有
</div>
</body>
</html>
