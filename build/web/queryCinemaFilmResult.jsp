<%-- 
    Document   : queryCinemaFilm
    Created on : Jun 12, 2019, 10:00:44 PM
    Author     : tellw
--%>

<%@page import="com.myapp.domain.Film"%>
<%@page import="com.myapp.dao.FilmDao"%>
<%@page import="java.util.Map"%>
<%@page import="com.myapp.domain.Room"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cinema.css" type="text/css">
        <title>影片安排查询结果</title>
        <style>
            table {
    margin: 0 20px;
    border-spacing: 0;
    text-align: center;
    border: solid 3px #f5eabe;
}

.strutsTable {
    margin: 0 auto;
}
h1{
    text-align: center;
}
        </style>
    </head>
    <body>
        <%List arrangedList = (List)request.getAttribute("arrangedList");
                String arrangeDate = (String)request.getAttribute("arrangeDate");
                Room room = (Room)request.getAttribute("room");
                %><h1><%if(arrangeDate!=null){%><%=arrangeDate%><%}%>&nbsp;&nbsp;&nbsp;&nbsp;<%if(room!=null){%><%=room.getRoomName()%><%}%></h1><br>
        <table class="strutsTable">
            <%Map map1 = null;
                if(arrangedList.size()!=0){
                for(int i=0; i<arrangedList.size(); i++){
            map1 = (Map)arrangedList.get(i);%>
                   <tr>
                       <td><%int filmId = Integer.parseInt(String.valueOf(map1.get("showFilmId")));
                       FilmDao filmDao = new FilmDao();
                       Film film = filmDao.getFilm(filmId);%><%=film.getFilmName()%></td>
                       <td><%int showScene = Integer.parseInt(String.valueOf(map1.get("showTime")));
                       int last = 0;
                           if(room.getRoomType()!=0){
                               last=2;
                           }else
                               last = 4;
                           %><%=8+last*(showScene-1)%>:00--<%=8+last*showScene%>:00
                           </td>
                           <td><%=map1.get("price")%></td>
            </tr>
                <%}%>
            <%}else if(room!=null && arrangedList==null){%>
            <h1>这一天这个房间还没有任何安排</h1><%}%>
        </table>
    </body>
</html>
