<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="/Vote/" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="page/css/style.css" />
<script type="text/javascript" src="page/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="page/js/view.js"></script>

</head>
<body>
<jsp:include page="top.jsp" />
<div id="vote" class="wrap">
	<h2>查看投票</h2>
	<ul class="list">
		
	<!--<li> 
			<p class="info">共有  个选项，已有  个网友参与了投票。</p>
				<ol>
					<li>
						<div class="rate">
							<div class="ratebg"><div class="percent" style="width:21"></div></div>
							<p>21票<span>(21%)</span></p>
						</div>
					</li>
				</ol> 
		</li>
				<div class="goback"><a href="page/index.jsp">返回投票列表</a></div>-->
	</ul>
</div>
<div id="footer" class="wrap">
	Wild &copy; 版权所有
</div>
</body>
</html>
