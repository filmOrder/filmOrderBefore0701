<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改影院信息</title>
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
	<form action="sinfoSlt?method=modify" method="post">
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影院密码:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="text" class="form-control" name="spwd" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">   
				<span class="aaa">影院地址:</span>   
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="text" class="form-control" name="saddr" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影院电话:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="text" class="form-control" name="stel" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-offset-3 col-md-2 item">
				<span class="aaa">影院提供服务:</span>
			</div>
			<div class="col-md-7">
				<div class="input-group input-group-md">
					<input type="text" class="form-control" name="sservice" />
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-offset-5 col-md-3 item-botton">
				<div class="btn-group btn-group-justified">
					<div class="btn-group">
						<button type="submit" class="btn btn-info">提交</button>
					</div>
				</div>
			</div>
		</div>
	
		<!-- 影厅id: <input type="text" name="id" /><br> 
		影厅名: <input  type="text" name="name" /><br> 
		影厅行数: <input type="text" name="rows" /><br> 
		影厅列数: <input type="text" name="cols" /><br>
		影厅描述: <input type="text" name="introduction" /><br> 
		影厅状态: <input  type="text" name="flag" /><br> 
		<input type="submit" value="Submit" /> -->
	</form>
</body>
</html>
