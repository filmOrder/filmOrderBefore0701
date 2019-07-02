<%-- 
    Document   : admin_buyerlist
    Created on : Jun 11, 2019, 12:26:10 AM
    Author     : tellw
--%>

<%@page import="java.util.List"%>
<%@page import="user.form.CustomForm"%>
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
<input type="button" value="返回管理主页" onclick="doBuyerBack()">
</div>
        <table class="strutsTable">
            <tr>
            <td>购票者手机号</td>
            <td>购票者用户名</td>
            <td>购票者用户密码</td>
            <td>购票者用户余额</td>
        </tr>
        <%List<CustomForm> noticeList = (List<CustomForm>)request.getAttribute("noticeList");
        for(int i = 0; i < noticeList.size(); i++){
            CustomForm customForm = noticeList.get(i);
        %>
        <tr>
            <td><%=customForm.getBuyerId()%></td>
            <td><%=customForm.getBuyerName()%></td>
            <td><%=customForm.getBuyerPwd()%></td>
            <td><%=customForm.getBuyerMoney()%></td>
        </tr>
        <%
        }
        %>
        </table>
    </body>
</html>
