<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="/Vote/" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布新投票</title>
<link type="text/css" rel="stylesheet" href="page/css/style.css" />
</head>
<body>
	<jsp:include page="top.jsp" />
	<div id="voteManage" class="box">
		<h2>添加新投票</h2>
		<div class="content">
			<form method="post" action="vote/insertVote">
				<dl>
					<dt>投票内容：</dt>
					<dd>
						<input type="hidden" name="entityId" value="" /> <input
							type="text" class="input-text" name="titleContent" value="" />
					</dd>
					<dt>投票类型：</dt>
					<dd>
						<input type="radio" name="subjectType" value="1" />单选 <input
							type="radio" name="subjectType" value="2" />多选
					</dd>
					<dt>投票选项：</dt>
					<dd id="voteoptions">
						<p>
							<input type="text" class="input-text" name="options" />
						</p>
						<p>
							<input type="text" class="input-text" name="mytext[]"
								id="field_1" value="" />
						</p>
					</dd>
					<dd id="voteoptions"></dd> 
					<dt></dt>
					<dd class="button">
						<input type="image" src="page/images/button_submit.gif" /> <a
							href="javascript:;" id="AddMoreFileBox">增加选项</a> <a
							href="page/index.jsp">取消操作</a>
					</dd>
				</dl>
			</form>
		</div>
	</div>
	<div id="footer" class="wrap">Wild &copy; 版权所有</div>
	<script type="text/javascript" src="page/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="page/js/addVote.js"></script>

</body>
</html>

