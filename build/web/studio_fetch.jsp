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
<title>查找影厅</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
<style type="text/css">
.msg {
	margin-top: 20px;
	margin-bottom: 24px;
	font-size: 18px;
	line-height: 28px;
	color: #333;
}

.aaa {
	text-align: right;
	font-size: 18px;
	color: #333;
	line-height: 45px;
}

.item {
	text-align: right;
}

.input-group {
	width: 320px;
}

.item-input {
	margin-bottom: 11px;
}

.item-select {
	margin-top: 11px;
}

.item-botton {
	margin-top: 11px;
	margin-bottom: 50px;
}
</style>
</head>
<body style="background-color: #FEFEFE">
	<%
//		List<Studio> studList = null;
		if (request.getAttribute("error") != null) {
			out.print("<script>alert('" + request.getAttribute("error") + "');</script>");
		}
//		if (request.getAttribute("list") != null) {
//			studList = (List<Studio>) request.getAttribute("list");
//		}
	%>
	<br>
	<form action="StudioSlt?method=fetch" method="post">
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影厅id:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="number" class="form-control" name="id" />
				</div>
			</div>
		</div>
<!--		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影厅名称:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="text" class="form-control" name="name" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影厅行数:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="text" class="form-control" name="rows" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影厅列数:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="text" class="form-control" name="cols" />
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影厅种类:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="text" class="form-control" name="stype" />
				</div>
			</div>
		</div>-->
		
		<div class="row">
			<div class="col-md-offset-5 col-md-3 item-botton">
				<div class="btn-group btn-group-justified">
					<div class="btn-group">
						<button type="submit" class="btn btn-info"
							>提交</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 影厅id: <input type="text" name="id" /><br> 
		影厅名: <input type="text" name="name" /><br> 
		影厅行数: <input type="text" name="rows" /><br> 
		影厅列数: <input type="text" name="cols" /><br>
		影厅描述: <input type="text" name="introduction" /><br> 
		影厅状态: <input type="text" name="flag" /><br> 
		<input type="submit"  value="Submit" /> -->
	</form>
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
<%--查询结果--%>
</style>
</body>
</html>