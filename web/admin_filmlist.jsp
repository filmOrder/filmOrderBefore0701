<%-- 
    Document   : admin_filmlist
    Created on : Jun 10, 2019, 1:34:33 PM
    Author     : tellw
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="film.form.FilmForm"%>
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
<input type="button" value="返回管理主页" onclick="doFilmBack()">
</div>
        <table class="strutsTable">
            <tr>
            <td>影片Id号</td>
            <td>影片名称</td>
            <td>影片时长</td>
            <td>影片摘要</td>
            <td>影片导演</td>
            <td>影片上映日期</td>
            <td>影片类型</td>
        </tr>
        <%List<FilmForm> filmList = (List<FilmForm>)request.getAttribute("filmList");
        for(int i = 0; i < filmList.size(); i++){
            FilmForm filmForm = filmList.get(i);
        %><tr>
            <td><%=filmForm.getFilmId()%></td>
            <td><%=filmForm.getFilmName()%></td>
            <td><%=filmForm.getDuration()%></td>
            <td><%=filmForm.getFilmAbstract()%></td>
            <td><%=filmForm.getDirective()%></td>
            <td><%=new SimpleDateFormat("yyyy-MM-dd").format(filmForm.getNewReleaseDate())%></td>
            <td><%=filmForm.getDurationType()%></td>
        </tr>
        <%
        }
        %>
        </table>
    </body>
</html>