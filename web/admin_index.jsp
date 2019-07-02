
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<head>
    <link rel="stylesheet" href="css/filmOrder.css" type="text/css">
        <script type="text/javascript" src="js/filmOrder.js"></script>
  <title>公告管理</title>
</head>
<body>
<ul>
                    <li>
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_index.jsp" style="color: red"><bean:message key="admin.ul.li.notice" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_film.jsp"><bean:message key="admin.ul.li.film" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_buyer.jsp"><bean:message key="admin.ul.li.buyer" /></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_cinema.jsp"><bean:message key="admin.ul.li.cinema" /></a>
                        <br>
                        <hr class="ulHrAdminIndex">
                    </li>
                </ul>
<div id="userActivityDiv">
<input type="button" value="退出登录" onclick="doAdminLogout()">
</div>
<form action="<%=request.getContextPath() %>/admin/getNotice.do" method="post">
  查看（输"0"查看全部数据库内容，输特定id号码查看特定内容）
  <table class="strutsTable">
    <tr>
      <td>Id：</td>
      <td><input type="number" name="noticeId" value="0"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
<form action="<%=request.getContextPath()%>/admin/addNotice.do" method="post">
    <table class="strutsTable">
    新建
    <tr>
      <td>公告内容：</td>
      <td><textarea rows="5" cols="100" type="text" name="noticeContent" placeholder="不要超过33字"></textarea></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
<form action="<%=request.getContextPath() %>/admin/deleteNotice.do" method="post">
  删除
  <table class="strutsTable">
    <tr>
      <td>Id：</td>
      <td><input type="number" name="noticeId"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
<form action="<%=request.getContextPath() %>/admin/updateNotice.do" method="post">
  更新
  <table class="strutsTable">
    <tr>
      <td>Id：</td>
      <td><input type="number" name="noticeId"></td>
    </tr>
    <tr>
      <td>公告内容：</td>
      <td><textarea rows="5" cols="100" type="text" name="noticeContent" placeholder="不要超过33字"></textarea></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
</body></html>
