

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<head>
    <link rel="stylesheet" href="css/filmOrder.css" type="text/css">
    <script type="text/javascript" src="js/filmOrder.js"></script>
  <title>影院管理</title>
</head>
<body>
<ul>
                    <li>
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_index.jsp"><bean:message key="admin.ul.li.notice" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_film.jsp"><bean:message key="admin.ul.li.film" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="ulA" href="${pageContext.request.contextPath}/admin_buyer.jsp"><bean:message key="admin.ul.li.buyer" /></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_cinema.jsp"  style="color: red"><bean:message key="admin.ul.li.cinema" /></a>
                        <br>
                        <hr class="ulHrAdminCinema">
                    </li>
                </ul>
<div id="userActivityDiv">
<input type="button" value="退出登录" onclick="doAdminLogout()">
</div>
<form action="<%=request.getContextPath() %>/admin/getCinema.do" method="post">
  查看（输"0"查看全部数据库内容，输特定id号码查看特定内容）
  <table class="strutsTable">
    <tr>
      <td>用户手机号：</td>
      <td><input type="text" name="cinemaId"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: center"><input type="button" value="查看全部影院信息" onclick="doAllCinemaList()"></td>
    </tr>
  </table>
</form>
<form action="<%=request.getContextPath() %>/admin/deleteCinema.do" method="post">
  删除
  <table class="strutsTable">
    <tr>
      <td>用户手机号：</td>
      <td><input type="text" name="cinemaId"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
<form action="<%=request.getContextPath() %>/admin/updateCinema.do" method="post">
  更新
  <table class="strutsTable">
    <tr>
      <td>用户手机号：</td>
      <td><input type="text" name="cinemaId"></td>
    </tr>
    <tr>
      <td>用户密码：</td>
      <td><input type="text" name="cinemaPwd"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
</body></html>
