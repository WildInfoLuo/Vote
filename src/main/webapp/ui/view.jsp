<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<jsp:include page="top.jsp" />
<div id="vote" class="wrap">
	<h2>查看投票</h2>
	<ul class="list">
		<li>
			<h4></h4>
			<p class="info">共有 <s:property value="subject.options.size"/> 个选项，已有 <s:property value="votes"/> 个网友参与了投票。</p>
				<ol>
				  <s:iterator value="subject.options" status="status"> 
					<li><s:property value="option.name"/>
						<div class="rate">
							<div class="ratebg"><div class="percent" style="width:<s:property value='statPercent[id]'/>%"></div></div>
							<p><s:property value="stat[id]"/>票<span>(<s:property value="statPercent[id]"/>%)</span></p>
						</div>
					</li>
				  </s:iterator>	
				</ol>
				<div class="goback"><a href="Subject!list.action?entityId=<s:property value='subject.id'/>">返回投票列表</a></div>
		</li>
	</ul>
</div>
<div id="footer" class="wrap">
	Wild &copy; 版权所有
</div>
</body>
</html>
