<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="DAO.*"%>
<%@ page import ="com.myapp.domain.Cinema"%>
<%@ page import="Service.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>影院管理系统主页</title>
<jsp:useBean id="sinfoSrv" scope="page"
	class="Service.sinfoSrv"></jsp:useBean>
</head>
<body style="background-color: #FEFEFE">
	<%
		
		
	%>
	<style>
		table.hovertable {
	font-family: verdana,arial,sans-serif;
	font-size:18px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.hovertable th {
	background-color:#c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.hovertable tr {
	background-color:#d4e3e5;
	font-size:18px;
}
table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
	font-size:18px;
}
</style>
<c:if test="${user!=null}">
	<table border="1" cellspacing="0" cellpadding="0" class="hovertable"
		width=100% align="center">
		<tr align="center">
			<th colspan="11">影院信息</th>
		</tr>
		<tr align="center">
			<td>影院id</td>
			<td>影院名称</td>
			<td>影院地址</td>
			<td>影院电话</td>
			<td>影院服务</td>
		
		</tr>
		<%
			Cinema cin = (Cinema)request.getSession().getAttribute("user");
		%>
                
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td><%=cin.getCinemaId()%></td>
			<td><%=cin.getCinemaName()%></td>
			<td><%=cin.getCinemaAddr()%></td>
			<td><%=cin.getCinemaTel()%></td>
			<td><%=cin.getCinemaService()%></td>
			
		</tr>
		
	</table>
</c:if>
<c:if test="${user==null}">
请登录</c:if>
</body>
</html>
