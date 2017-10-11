<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>更新书籍</title>
</head>
<body>
	<h1>更新书籍数据</h1>
		<s:form action = "updatebook">
			作者名字:<input type="text" name="Name"/><br/>
			年龄:   <input type="text" name="Age"/><br/>
			国籍:   <input type="text" name="Country"/><br/>
			出版社: <input type="text" name="Publisher"/><br/>
			出版日期:<input type="text" name="PublishDate"/><br/>
			价格:   <input type="text" name="Price"/><br/>
			ISBN:  <input type="text" name="ISBN"/><br/>
			（注：ISBN要与地址栏一致）
		                  <s:submit value = "更新"/>
		</s:form>
</body>
</html>