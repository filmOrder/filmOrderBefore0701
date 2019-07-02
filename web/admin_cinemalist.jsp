<%-- 
    Document   : admin_cinemalist
    Created on : Jun 11, 2019, 2:47:58 AM
    Author     : tellw
--%>

<%@page import="java.util.List"%>
<%@page import="user.form.CinemaForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/filmOrder.css" type="text/css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/filmOrder.js"></script>
        <title>查询结果</title>
    </head>
    <body>
        <div id="userActivityDiv">
<input type="button" value="返回管理主页" onclick="doCinemaBack()">
</div>
        <table class="strutsTable">
            <tr>
            <td>影院负责人手机号</td>
            <td>影院负责人用户名</td>
            <td>影院负责人用户密码</td>
            <td>影院名称</td>
            <td>影院地址</td>
            <td>影院电话</td>
            <td>影院所供服务</td>
            <td>影院余额</td>
            </tr>
        <%List<CinemaForm> noticeList = (List<CinemaForm>)request.getAttribute("noticeList");
        for(int i = 0; i < noticeList.size(); i++){
            CinemaForm cinemaForm = noticeList.get(i);
        %><tr>
            <td><%=cinemaForm.getCinemaId()%></td>
            <td><%=cinemaForm.getCinemaUsrName()%></td>
            <td><%=cinemaForm.getCinemaPwd()%></td>
            <td><%=cinemaForm.getCinemaName()%></td>
            <td><%=cinemaForm.getCinemaAddr()%></td>
            <td><%=cinemaForm.getCinemaTel()%></td>
            <td><%=cinemaForm.getCinemaService()%></td>
            <td><%=cinemaForm.getCinemaMoney()%></td>
        </tr>
        <%
        }
        %>
        </table>
    </body>
</html>

