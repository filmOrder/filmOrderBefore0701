<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ page import="Servlet.*"%>
<%@ page import="Service.*"%>
<%@ page import="DAO.*"%>
<%@ page import="Domain.*"%>
<title>添加影厅</title>
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
		if (request.getAttribute("error") != null) {
			out.print("<script>alert('" + request.getAttribute("error") + "');</script>");
		}
	%>
	<br>
	<form action="StudioSlt?method=add" method="post">
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影厅名:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="text" class="form-control" name="name" />  <%--表单 --%>
				</div>
			</div>
		</div> 
            
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影厅行数:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="number" class="form-control" name="rows" />   
				</div>
			</div>
		</div>
            
		
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影厅列数:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="number" class="form-control" name="cols" />   
				</div>
			</div>
		</div>
            
		
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影厅种类:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="number" class="form-control" name="stype" placeholder="填0表示4小时影厅，填其他值表示2小时影厅"/>   
				</div>
			</div>
		</div>
            
		<br><br>
		
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
		
	</form>
</body>
</html>