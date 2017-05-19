<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="/Vote/" />
<title></title>
<link type="text/css" rel="stylesheet" href="page/css/style.css" />
</head>
<body>
	<div id="header" class="wrap">
		<img src="page/images/logo.gif" />
	</div>
	<div id="login" class="wrap">
		<div class="main">
			<div class="corner"></div>
			<div class="introduce">
				<h2>Vote</h2>
				<p>网上投票系统...</p>
			</div>
			<div class="login">
				<h2>用户登录</h2>
				<form method="post" action="vuser/login">
					<dl id="loginBox">
						<dt>用户名：</dt>
						<dd>
							<input type="hidden" name="vuversion" value=""/>
							<input type="text" class="input-text" id="vuId"  name="vphone" value="" />
						</dd>
						<dt>密 码：</dt>
						<dd>
							<input type="password" class="input-text" id="vupassword"  name="vupassword"
								value="" />
						</dd>
						<dt></dt>
						<dd>
							<input type="submit" class="input-button" id="login"
								value="登录" /> <a href="page/register.jsp">新用户注册</a>
						</dd>
					</dl>
				</form>
			<div class="error">${regErrorMsg }</div>
			</div>
		</div>
	</div>
	<div class="wrap"></div>
	<div id="footer" class="wrap">Wild &copy; 版权所有</div>
	<script type="text/javascript" src="page/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="page/js/security.js"></script>
	<script type="text/javascript" src="page/js/login.js"></script>
</body>
</html>
