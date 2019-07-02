
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<head>
    <link rel="stylesheet" href="css/filmOrder.css" type="text/css">
    <script type="text/javascript" src="js/filmOrder.js"></script>
  <title>购票者管理</title>
</head>
<body>
<ul>
                    <li>
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_index.jsp"><bean:message key="admin.ul.li.notice" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_film.jsp"><bean:message key="admin.ul.li.film" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="ulA" href="${pageContext.request.contextPath}/admin_buyer.jsp" style="color: red"><bean:message key="admin.ul.li.buyer" /></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_cinema.jsp"><bean:message key="admin.ul.li.cinema" /></a>
                        <br>
                        <hr class="ulHrAdminBuyer">
                    </li>
                </ul>
<div id="userActivityDiv">
<input type="button" value="退出登录" onclick="doAdminLogout()">
</div>
<form action="<%=request.getContextPath() %>/admin/getCustom.do" method="post">
  查看（输"0"查看全部数据库内容，输特定id号码查看特定内容）
  <table class="strutsTable">
    <tr>
      <td>用户手机号：</td>
      <td><input type="text" name="buyerId"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: center"><input type="button" value="查看全部购票者信息" onclick="doAllBuyerList()"></td>
    </tr>
  </table>
</form>
<form action="<%=request.getContextPath() %>/admin/deleteCustom.do" method="post">
  删除
  <table class="strutsTable">
    <tr>
      <td>用户手机号：</td>
      <td><input type="text" name="buyerId"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
<form action="<%=request.getContextPath() %>/admin/updateCustom.do" method="post">
  更新
  <table class="strutsTable">
    <tr>
      <td>用户手机号：</td>
      <td><input type="text" name="buyerId"></td>
    </tr>
    <tr>
      <td>用户密码：</td>
      <td><input type="text" name="buyerPwd"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
</body></html>

