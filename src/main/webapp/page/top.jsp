<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<base href="/Vote/">
<div id="header" class="wrap">
	<img src="page/images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="profile">
		您好，<%	%>
		<span class="return"><a href="page/index.jsp">返回列表</a></span> <span
			class="addnew"><a href="page/add.jsp">添加新投票</a></span> <span
			class="modify"><a href="page/manage.jsp">维护</a></span>

	</div>
	<div class="search">
		<form method="post" action="Subject!search.action">
			<input type="text" name="keywords" class="input-text"
				value="<s:property value='keywords'/>" /><input type="submit"
				name="submit" class="input-button" value="" />
		</form>
	</div>
</div>
