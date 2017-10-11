<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix='s' uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
    
    <title>图书库</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<h1 style="text-align:center" style="color:#F00;">欢迎来到我的图书库</h1>
<body>
	<h2>查询作者所著书籍题目</h2>
	<s:form action="QueryAuthor"  >
	作者名字：<input type="text" name="Authorname" /><br />
	（可查询：东野圭吾，亦舒，乔治·奥威尔，马里奥·普佐，鲁迅，葛亮）
	<s:submit value="查询" /> <br />
	</s:form>
	
	<h2>插入一本书</h2>
	<s:form action="insert"  >
		作者名字：<input type="text" name="Authorname" /><br />
		作者ID：   <input type="text" name="AuthorID" /><br />
		ISBN:    <input type="text" name="ISBN" /><br />
		书名：       <input type="text" name="Title" /><br />
		出版方：    <input type="text" name="Publisher" /><br />
		出版日期：<input type="text" name="PublishDate" /><br />
		价格：       <input type="text" name="Price" />
	                    <s:submit value="Submit" /> <br />
	</s:form>
</body>
</html>