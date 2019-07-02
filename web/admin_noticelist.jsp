<%-- 
    Document   : admin_list
    Created on : Jun 9, 2019, 9:03:28 PM
    Author     : tellw
--%>

<%@page import="java.util.List"%>
<%@page import="notice.form.NoticeForm"%>
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
<input type="button" value="返回管理主页" onclick="doAdminBack()">
</div>
        <table class="strutsTable">
            <tr>
            <td>公告Id号</td>
            <td>公告内容</td>
            <td>公告发布时间</td>
        </tr>
        <%List<NoticeForm> noticeList = (List<NoticeForm>)request.getAttribute("noticeList");
        for(int i = 0; i < noticeList.size(); i++){
            NoticeForm noticeForm = noticeList.get(i);
        %><tr>
            <td><%=noticeForm.getNoticeId()%></td>
            <td><%=noticeForm.getNoticeContent()%></td>
            <td><%=noticeForm.getNoticeTime()%></td>
        </tr>
        <%
        }
        %>
        </table>
    </body>
</html>
