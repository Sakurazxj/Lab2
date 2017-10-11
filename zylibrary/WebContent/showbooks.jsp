<%@ page language="java" import="java.util.*" 
contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>书单</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<script type="text/javascript">
function details(e)
{
	var Title = document.getElementById("Title");
	window.location.href = "showDetails?Title="+e.innerHTML;
	window.event.returnValue=false; 
}
</script>
<style>
a:hover{ background-color:yellow;}
</style>
</head>
<body>
 <h1>该作者所著书籍</h1>
		<s:property value = "Authorname"/>
		
		<table border="1">
			<s:iterator value="Booklist" id="String" status = "status">
			<tr>
			<td>
				<a href="javascript:void(0);" onclick="details(this);"><s:property value="String"/></a>
				<!-- javascript:void(0),没启实质上的作用，它仅仅是一个死链接，执行的函数是details(this)这样悬停效果也有效 -->
				
			</td>
			</tr>
			</s:iterator>
		</table>
<input type="button" value="返回首页" onclick="window.location='http://zylibrary.applinzi.com/'"/>	
</body>
</html>