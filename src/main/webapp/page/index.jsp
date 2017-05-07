<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="/Vote/" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投票列表</title>
<link type="text/css" rel="stylesheet" href="page/css/style.css" />
</head>
<body>
<jsp:include page="top.jsp" />
<div id="vote" class="wrap">
	<h2>投票列表</h2>
	<ul class="list">
	
		<li>
			<h4>				
				<a href="page/view.jsp">sdfsdf<s:property value="title"/></a>
			</h4>
			<div class="join"><a href="Vote.action?entityId=<s:property value='id'/>">我要参与</a></div>
			<p class="info">共有 <s:property value="options.size"/> 个选项，已有 <s:property value="votes[id]"/> 个网友参与了投票。</p>
		</li>
	</ul>
</div>
<div id="footer" class="wrap">
	Wild &copy; 版权所有
</div>
</body>
</html>
