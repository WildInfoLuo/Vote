<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="/Vote/" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投票列表</title>
<link type="text/css" rel="stylesheet" href="page/css/style.css" />
<script type="text/javascript" src="page/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="page/js/index.js"></script>
</head>
<body>
	<jsp:include page="top.jsp" />
	<div id="vote" class="wrap">
		<h2>投票列表</h2>
		<ul class="list">
			<c:forEach items="${subject }" var="item">
				<li>
					<h4>
						<a href="javascript:void(0)" onclick="viewVote('${item.vsid}')" >${item.vstitle }</a>
					</h4>
					<div class="join">
						<a href="page/vote.jsp">我要参与</a>
					</div>
					<p class="info">
						<a href="page/view.jsp">${item.vstitle }</a>
						共有${item.vs_Type } 个选项，已有 个网友参与了投票。
					</p>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div id="footer" class="wrap">Wild &copy; 版权所有</div>
</body>
</html>
