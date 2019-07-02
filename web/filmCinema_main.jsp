<%-- 
    Document   : filmCinema_main
    Created on : Jun 12, 2019, 1:23:44 PM
    Author     : tellw
--%>

<%@page import="com.myapp.domain.Room"%>
<%@page import="com.myapp.dao.RoomDao"%>
<%@page import="com.myapp.domain.Cinema"%>
<%@page import="common.util.StringUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.myapp.domain.Film"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.myapp.dao.FilmDao"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/filmOrder.css" type="text/css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/filmOrder.js"></script>
        <title>影片管理</title>
        <style>
/*            table {
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
body {
    background-image: url('/filmOrder/img/all_bg.png');
    text-align: center;
    margin: 20px auto;
    font-size: 100%;
    height: 100%;
    overflow-y: auto;
}*/
        </style>
    </head>
    <body>
        <%
		if (request.getAttribute("error") != null) {
			out.print("<script>alert('" + request.getAttribute("error") + "');</script>");
		}
	%>
	<br>
        <%String showFilmId = request.getParameter("showFilmId");
        String arrangeDate = request.getParameter("arrangeDate");
        String roomId = request.getParameter("roomId");
        FilmDao filmDao = new FilmDao();
        if(showFilmId == null){%>
        <table class="strutsTable">
            <%
            List list = filmDao.searchFilmDate(1);
            Map map = null;
            if(list!=null){
                for(int i = 0; i < list.size(); i++){
            map = (Map)list.get(i);%>
                <tr>
                <td><%=map.get("filmName")%></td>
                <td><input type="button" value="安排" onclick="location.href='${pageContext.request.contextPath}/filmCinema_main.jsp?showFilmId=<%=map.get("filmId")%>'"></td>
                </tr>
                <%}
            }else{%>
            <h1>无可以安排的电影</h1><%}%>
        </table>
        <%}else{
Film film = filmDao.getFilm(Integer.parseInt(showFilmId));%>
<div id="cinemaWelcomeDiv">
    <input type="button" value="返回上页" onclick="location.href='${pageContext.request.contextPath}/filmCinema_main.jsp'"></div>
<h1><%=film.getFilmName()%></h1><br>
<table class="strutsTable">
    <tr>
        <td>上映日期：</td><td><%=new SimpleDateFormat("yyyy-MM-dd").format(film.getReleaseDate())%></td></tr>
    <tr><td>时长：</td><td><%=film.getDuration()%>分钟</td></tr>
    <tr><td>剧情概要：</td><td><%=film.getFilmAbstract()%></td></tr>
    <tr><td>导演：</td><td><%=film.getDirective()%></td></tr>
    <tr><td>标签:</td><td><%=StringUtil.filmTagConvert(film.getDurationType())%></td></tr>
</table>
<%Cinema cinema = (Cinema)session.getAttribute("user");
            if(cinema!=null){%>
    <form action="${pageContext.request.contextPath}/queryFilmCinemaArrangeSlt" method="post">
    <table class="strutsTable">
        <tr>
            <td>安排日期<input type="date" name="arrangeDate"></td>       
                    <%RoomDao roomDao = new RoomDao();
                    List roomList = roomDao.getAllRoomsByCinema(cinema);
                    Map map = null;
                    if(roomList.size() != 0){%>
            <td>安排影厅<input type="text" name="arrangeRoom" list="roomList">
                <datalist id="roomList">
                        <%for(int i = 0; i < roomList.size(); i++){
                            map = (Map)roomList.get(i);%>
                            <option><%=map.get("roomName")%></option>
                        <%}%>
</datalist></td>
<td><input type="hidden" value="<%=showFilmId%>" name="showFilmId"></td>
<td><input type="submit" value="查询"></td></tr>
    </table></form>
                    <%if(arrangeDate != null && roomId!=null){
                        List arrangedList = (List)request.getAttribute("arrangedList");
                        Room room = roomDao.getRoomById(Integer.parseInt(roomId));
//                String arrangeDate = (String)request.getAttribute("arrangeDate");
//                Room room = (Room)request.getAttribute("room");
                %><h1><%=arrangeDate%>&nbsp;&nbsp;&nbsp;&nbsp;<%=room.getRoomName()%></h1><br>
        <table class="strutsTable">
            <%Map map1 = null;
                if(arrangedList!=null){
                    if(arrangedList.size()>0){
                for(int i=0; i<arrangedList.size(); i++){
            map1 = (Map)arrangedList.get(i);%>
                   <tr>
                       <td><%int filmId = Integer.parseInt(String.valueOf(map1.get("showFilmId")));
                       film = filmDao.getFilm(filmId);%><%=film.getFilmName()%></td>
                       <td><%int showScene = Integer.parseInt(String.valueOf(map1.get("showTime")));
                       int last = 0;
                           if(room.getRoomType()!=0){
                               last=2;
                           }else
                               last = 4;
                           %><%=8+last*(showScene-1)%>:00--<%=8+last*showScene%>:00
                           </td>
                           <td><%=map1.get("price")%>元</td>
            </tr>
                <%}%>
            <%}else{%>
            <h1>这一天这个房间还没有任何安排</h1><%}}%>
        </table>
        新建影片安排
<form action="${pageContext.request.contextPath}/addCinemaFilmSlt" method="post">
    <table class="strutsTable">
        <tr>
            <td>安排日期<input type="date" name="arrangeDate"></td></tr>       
        <tr><td>安排影厅<input type="text" name="arrangeRoom" list="roomList">
                <datalist id="roomList">
                        <%for(int i = 0; i < roomList.size(); i++){
                            map = (Map)roomList.get(i);%>
                            <option><%=map.get("roomName")%></option>
                        <%}%>
                </datalist></td></tr>
        <tr><td>安排场次<input type="number" name="arrangeTime"></td></tr>
        <tr><td>note:若电影时长超过120分钟，请填1-5五个数字，分别代表从8点开始时间间隔为4小时的时间段</td></tr>
        <tr><td>note:若电影时长小于120分钟，请填1-9五个数字，分别代表从8点开始时间间隔为2小时的时间段</td></tr>
        <tr><td>电影价格<input type="number" name="price">元</td></tr>
        <tr><td><input type="hidden" value="<%=showFilmId%>" name="showFilmId"></td></tr>
        <tr><td><input type="submit" value="添加"></td></tr>
    </table>
</form>
                    <%}}else{%>
                    <h1>您还未增添一个影厅</h1>
<%}%>
<%}else{%>
<h1>请登录</h1>
<%}}%>
    </body>
</html>
