<%@ page language="java" import="java.util.*" 
contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>图书和作者简介</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<script type="text/javascript">
function deletes(e)
{
	var ISBN = document.getElementById("ISBN");
	alert("请确定要删除ISBN:"+ISBN.innerHTML+"的书籍");
	window.location.href = "delete?ISBN="+ISBN.innerHTML;
	window.event.returnValue=false;
}

function updates(t){
	var ISBN = document.getElementById("ISBN");
	alert("请确定要更新ISBN:"+ISBN.innerHTML+"的书籍");
	window.location.href = "update?ISBN="+ISBN.innerHTML;
	window.event.returnValue=false;
}
</script>
<style>
a:hover{ background-color:yellow;}
</style>
</head>
<body>
	<h1>图书介绍</h1>
		<p id="ISBN"><s:property value="ISBN"/></p>
		<hr/>
		AuthorID:<s:property value="AuthorID"/>
		<hr/>
		Publisher:<s:property value="Publisher"/>
		<hr/>
		PublishDate:<s:property value="PublishDate"/>
		<hr/>
		Price:<s:property value="Price"/> RMB
		<hr/>
		<a href="javascript:void(0);" onclick="deletes(this);">
		删除本书记录
		</a><br>
		<a href="javascript:void(0);" onclick="updates(this);">
		更新本书数据
		</a>
	<h1>作者介绍</h1>
		<p id="AuthorID">AuthorID:<s:property value="AuthorID"/></p>
		<hr/>
		Name:<s:property value="Name"/>
		<hr/>
		Age:<s:property value="Age"/>
		<hr/>
		Country:<s:property value="Country"/>
		<hr/>
	<input type="button" value="返回首页" onclick="window.location='http://zylibrary.applinzi.com/'"/>
</body>
</html>