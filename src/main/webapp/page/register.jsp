<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="/Vote/" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注 册</title>
<link type="text/css" rel="stylesheet" href="page/css/style.css" />
</head>

<body>
	<div id="header" class="wrap">
		<img src="page/images/logo.gif" />
	</div>
	<div id="navbar" class="wrap">
		<div class="search"></div>
	</div>
	<div id="register" class="box">
		<h2>新用户注册</h2>
		<div class="content" id="contents">
			<form method="post" action="vuser/register">
				<dl>
					<dt>手机号码：</dt>
					<dd>
						<input type="text" class="input-text" id="phoneId" name="phoneId"
							value="" />
					</dd>
					<dd>
						<input type="button" value="获取验证码" onclick="sendcheckcode()" />
					</dd>
					<dt>用户名：</dt>
					<dd>
						<input type="text" class="input-text" id="userName"
							name="userName" value="" />
					</dd>
					<dt>密码：</dt>
					<dd>
						<input type="password" class="input-text" id="password"
							name="vpwd" value="" />
					</dd>
					<dt>验证码：</dt>
					<dd>
						<input type="text" class="input-text" id="messages"
							name="messages" value="" />
					</dd>
					<dd>
						<input type="submit" class="input-button" id="save" value=""
							onclick="saves()" />
					</dd>
				</dl>
			</form>
			<div class="error">${regErrorMsg }</div>
		</div>
	</div>
	<div id="footer" class="wrap">Wild &copy; 版权所有</div>
	<script type="text/javascript" src="page/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="page/js/register.js"></script>
</body>
</html>
