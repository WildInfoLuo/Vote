<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布新投票</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<jsp:include page="top.jsp" />
	<div id="voteManage" class="box">
		<h2>添加新投票</h2>
		<div class="content">
			<form method="post" action="">
				<dl>
					<dt>投票内容：</dt>
					<dd>
						<input type="hidden" name="entityId"
							value="<s:property value='subject.id'/>" /> <input type="text"
							class="input-text" name="subject.title"
							value="<s:property value='subject.title'/>" />
					</dd>
					<dt>投票类型：</dt>
					<dd>
						<input type="radio" name="subject.type"
							<s:if test="subject.type==1"> checked="checked" </s:if> value="1" />单选
						<input type="radio" name="subject.type"
							<s:if test="subject.type==2"> checked="checked" </s:if> value="2" />多选
					</dd>
					<dt>投票选项：</dt>
					<dd id="voteoptions">
						<p>
							<input type="text" class="input-text" name="options" />
						</p>
						<p>
							<input type="text" class="input-text" name="options" />
						</p>
					</dd>
					<dd id="voteoptions">
						<p>
							<input type="text" class="input-text"
								name="option_<s:property value='id'/>"
								value="<s:property value='name'/>" /> <a class="del"
								href="javascript:;" onclick="DelOption()">删除</a>
						</p>
					</dd>
					<dt></dt>
					<dd class="button">
						<input type="image" src="images/button_submit.gif" /> <a
							href="javascript:;" onclick="AddOption()">增加选项</a> <a
							href="Subject!list.action">取消操作</a>
					</dd>
				</dl>
			</form>
		</div>
	</div>
	<div id="footer" class="wrap">Wild &copy; 版权所有</div>
</body>
</html>

