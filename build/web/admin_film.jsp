
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<head>
    <link rel="stylesheet" href="css/filmOrder.css" type="text/css">
        <script type="text/javascript" src="js/filmOrder.js"></script>
  <title>影片管理</title>
</head>
<body>
<ul>
                    <li>
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_index.jsp"><bean:message key="admin.ul.li.notice" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_film.jsp" style="color: red"><bean:message key="admin.ul.li.film" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_buyer.jsp"><bean:message key="admin.ul.li.buyer" /></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/admin_cinema.jsp"><bean:message key="admin.ul.li.cinema" /></a>
                        <br>
                        <hr class="ulHrAdminFilm">
                    </li>
                </ul>
<div id="userActivityDiv">
<input type="button" value="退出登录" onclick="doAdminLogout()">
</div>
<form action="<%=request.getContextPath() %>/admin/getFilm.do" method="post">
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
<form action="<%=request.getContextPath()%>/admin/addFilm.do" method="post">
    <table class="strutsTable">
    新建
    <tr>
      <td>电影名：</td>
      <td><input type="text" name="filmName" placeholder="不要超过15字"></td>
    </tr>
    <tr>
        <td>时长：</td>
        <td><input type="number" name="duration">分钟</td>
    </tr>
    <tr>
      <td>摘要：</td>
      <td><textarea rows="3" cols="40" type="text" name="filmAbstract" placeholder="不要超过100字"></textarea></td>
    </tr>
    <tr>
      <td>导演名：</td>
      <td><input type="text" name="directive" placeholder="不要超过6字"></td>
    </tr>
    <tr>
      <td>上映日期：</td>
      <td><input type="date" name="releaseDate"></td>
    </tr>
    <tr>
      <td>电影类型：</td>
      <td><input type="text" name="durationType" placeholder="按照要求选择不需要空格"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center">电影类型请从“动作”、“喜剧”、“爱情”、“科幻”、“剧情”、“恐怖”、”战争“七种中选择</td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
<form action="<%=request.getContextPath() %>/admin/deleteFilm.do" method="post">
  删除
  <table class="strutsTable">
    <tr>
      <td>Id：</td>
      <td><input type="number" name="filmId"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
<form action="<%=request.getContextPath() %>/admin/updateFilm.do" method="post">
  更新
  <table class="strutsTable">
    <tr>
      <td>Id：</td>
      <td><input type="number" name="filmId"></td>
    </tr>
    <tr>
      <td>电影名：</td>
      <td><input type="text" name="filmName" placeholder="不要超过15字"></td>
    </tr>
    <tr>
        <td>时长：</td>
        <td><input type="number" name="duration">分钟</td>
    </tr>
    <tr>
      <td>摘要：</td>
      <td><textarea rows="3" cols="40" type="text" name="filmAbstract" placeholder="不要超过100字"></textarea></td>
    </tr>
    <tr>
      <td>导演名：</td>
      <td><input type="text" name="directive" placeholder="不要超过6字"></td>
    </tr>
    <tr>
      <td>上映日期：</td>
      <td><input type="date" name="releaseDate"></td>
    </tr>
    <tr>
      <td>电影类型：</td>
      <td><input type="text" name="durationType" placeholder="按照要求选择不需要空格"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center">电影类型请从“动作”、“喜剧”、“爱情”、“科幻”、“剧情”、“恐怖”、”战争“七种中选择</td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
</body></html>

