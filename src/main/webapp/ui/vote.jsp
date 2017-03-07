<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>参与投票</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<jsp:include page="top.jsp" />
<div id="vote" class="wrap">
	<h2>参与投票</h2>
	<ul class="list">
		<li>
			<h4><s:property value="subject.title"/></h4>
			<p class="info">共有 <s:property value="subject.options.size"/> 个选项，已有 <s:property value="votes"/> 个网友参与了投票。</p>
			<form method="post" action="Vote!save.action">
			    <input type="hidden" name="entityId" value="<s:property value='subject.id'/>"/> 
				<ol>
				  <s:iterator value="subject.options" status="status"> 
					<li><input <s:if test="subject.type==2">type="checkbox"</s:if><s:else>type="radio"</s:else> name="options"  value="<s:property value='id'/>"/><s:property value="name"/></li>
				  </s:iterator>	
				</ol>
				<p class="voteView"><input type="image" src="images/button_vote.gif" /><a href="Vote!view.action?entityId=<s:property value='subject.id'/>"><img src="images/button_view.gif" /></a></p>
			</form>
		</li>
	</ul>
</div>
<div id="footer" class="wrap">
	Wild &copy; 版权所有
</div>
</body>
</html>
