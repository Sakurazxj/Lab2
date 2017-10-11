<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix='s' uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增添作者到库</title>
</head>
<h1>作者信息</h1>
<body>
	<s:form action="addauthor"  >
		作者名字：<s:textfield name="Name" /><br />
		作者ID：   <s:textfield name="AuthorID" /><br />
		年龄:    <s:textfield name="Age" /><br />
		国籍：       <s:textfield name="Country" /><br />
	                <s:submit value="Submit" /> <br />
	</s:form>
</body>
</html>