<%-- 
    Document   : buy
    Created on : Jun 13, 2019, 4:01:32 AM
    Author     : tellw
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.myapp.dao.CinemaFilmDao"%>
<%@page import="common.util.StringUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.myapp.domain.Cinema"%>
<%@page import="com.myapp.dao.CinemaDao"%>
<%@page import="com.myapp.domain.Film"%>
<%@page import="com.myapp.dao.FilmDao"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<title><bean:message key="buy.title" /></title>
<!--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>-->
<c:if test="${user!=null}">
    <%
		if (request.getAttribute("error") != null) {
			out.print("<script>alert('" + request.getAttribute("error") + "');</script>");
		}
	%>
        <%String filmId = request.getParameter("filmId");
        String cinemaId = request.getParameter("cinemaId");
        if(filmId!=null && cinemaId!=null){
            Film film = new FilmDao().getFilm(Integer.parseInt(filmId));
            Cinema cinema = new CinemaDao().find1(cinemaId);%>
            <h1><%=cinema.getCinemaName()%></h1><br>
<table class="strutsTable">
    <tr>
        <td>地址：</td><td><%=cinema.getCinemaAddr()%></td></tr>
    <tr><td>电话：</td><td><%=cinema.getCinemaTel()%></td></tr>
    <tr><td>服务详情：</td><td><%=cinema.getCinemaService()%></td></tr></table>
    <h1><%=film.getFilmName()%></h1><br>
<table class="strutsTable">
    <tr>
        <td>上映日期：</td><td><%=new SimpleDateFormat("yyyy-MM-dd").format(film.getReleaseDate())%></td></tr>
    <tr><td>时长：</td><td><%=film.getDuration()%>分钟</td></tr>
    <tr><td>剧情概要：</td><td><%=film.getFilmAbstract()%></td></tr>
    <tr><td>导演：</td><td><%=film.getDirective()%></td></tr>
    <tr><td>标签:</td><td><%=StringUtil.filmTagConvert(film.getDurationType())%></td></tr>
</table>
<%CinemaFilmDao cinemaFilmDao = new CinemaFilmDao();
List couldBuy = cinemaFilmDao.getBuyResource(Integer.parseInt(filmId), cinemaId);
Map map = null;
if(couldBuy!=null && couldBuy.size()>0){
    for(int i = 0; i<couldBuy.size(); i++){
        map = (Map)couldBuy.get(i);%>
        <form action="${pageContext.request.contextPath}/filmTicketBuy.do" method="post">
            <table class="strutsTable">
                <tr><td><%=map.get("roomName")%></td>
                <td><%=map.get("showDate")%>&nbsp;&nbsp;&nbsp;&nbsp;<%int showScene = Integer.parseInt(String.valueOf(map.get("showTime")));
                       int last = 0;
                           if(Integer.parseInt(String.valueOf(map.get("roomType")))!=0){
                               last=2;
                           }else
                               last = 4;
                           %><%=8+last*(showScene-1)%>:00--<%=8+last*showScene%>:00
                           </td></tr>
                <tr><td><input type="text" name="selectedRow" list="rowList">
                    <datalist id="rowList">
                        <%for(int eachRow = 1; eachRow < Integer.parseInt(String.valueOf(map.get("roomRow"))); eachRow++){%>
                            <option><%=eachRow%></option>
                        <%}%>
</datalist></td><td><input type="text" name="selectedColumn" list="columnList">
                    <datalist id="columnList">
                        <%for(int eachColumn = 1; eachColumn < Integer.parseInt(String.valueOf(map.get("roomColumn"))); eachColumn++){%>
                            <option><%=eachColumn%></option>
                        <%}%>
</datalist></td></tr>
                <tr><td><%=map.get("price")%>元</td><td><input type="hidden" value="<%=map.get("cinemaFilmId")%>" name="cinemaFilmId"><input type="submit" value="购买"></td></tr>
            </table>
        </form>
 <%   }
}else if(couldBuy == null || couldBuy.size()==0){%>
    <h1>并无可售的电影票</h1>
<%}
    %>
        <%}else if(filmId==null ||cinemaId==null){%>
        <h1>抱歉，您不能这样访问页面</h1>
        <%}%>
        </c:if>
        <c:if test="${user==null}">
            <h1>请登录</h1>
        </c:if>
<!--    </body>
</html>-->
