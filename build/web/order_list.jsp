<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="Servlet.*"%>
<%@ page import="Service.*"%>
<%@ page import="DAO.*"%>
<%@ page import="Domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>影院管理系统主页</title>
<jsp:useBean id="OrderSrv" scope="page"
	class="Service.OrderSrv"></jsp:useBean>
</head>
<body style="background-color: #FEFEFE">
	<%
		List<Order> orderList = OrderSrv.FetchAll();
		if (request.getAttribute("error") != null) {
			out.print("<script>alert('" + request.getAttribute("error") + "');</script>");
		}
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
	<table border="1" cellspacing="0" cellpadding="0" class="hovertable" width=100%
		align="center">
		<tr align="center">
			<th colspan="11" >订单列表</th>
		</tr>
		<tr align="center">
			<td>订单ID</td>
			<td>购买者ID</td>
			<td>影片名称</td>
			<td>座位行</td>
			<td>座位列</td>
			<td>下单时间</td>
			
		</tr>
		<%
				for (int i = 0; i < orderList.size(); i++) {
		%>
		<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td><%=orderList.get(i).getorderId()%></td>
			<td><%=orderList.get(i).getbuyerId()%></td>
			<td><%=orderList.get(i).getfilmName()%></td>
			<td><%=orderList.get(i).getseatRow()%></td>
			<td><%=orderList.get(i).getseatColumn()%></td>
			<td><%=orderList.get(i).getorderTime()%></td>
		</tr>
		<%
			}
				if (orderList.size() == 0) {
		%>
		<tr>
			<th colspan="11">无订单信息！</th>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>