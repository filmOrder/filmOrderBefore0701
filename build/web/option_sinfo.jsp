<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>侧边栏</title>
<style type="text/css">
  #menu{margin-top: 10px;width:100%;padding:0;}
  #menu li{display:block;width:100%}
  #menu li a{display:inline-block; text-align:center;height:30px; line-height:30px;width:100%;
            color:black; font-family:"\5FAE\8F6F\96C5\9ED1"; font-size:18px ;text-decoration: none}
  #menu li a:hover{background:#4489FE;}
  body{
  	background-color:#ccc;
  	margin:0px;
  	padding:0;
  }
</style>
</head>
<body style="background-color:#03A8F3">
<ul id="menu" style="list-style:none">
<li><a href="sinfo_list.jsp" target="frame_right"><font color="#FEFEFE">影厅信息</font></a></li>
<li><a href="sinfo_modify.jsp" target="frame_right"><font color="#FEFEFE">编辑信息</font></a></li>
</ul>
</body>
</html>
