<%-- 
    Document   : cinemaShow
    Created on : Jun 8, 2019, 7:38:26 PM
    Author     : tellw
--%>

<%@page import="common.util.StringUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.myapp.dao.FilmDao"%>
<%@page import="com.myapp.domain.Film"%>
<%@page import="com.myapp.dao.CinemaFilmDao"%>
<%@page import="com.myapp.domain.Cinema"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.myapp.dao.CinemaDao"%>
<!--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>-->
<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<title><bean:message key="cinemaShow.title" /></title>
        <div id="headerUl">
                <ul>
                    <li>
                        <a class="ulA" href="${pageContext.request.contextPath}/index.jsp"><bean:message key="ul.li.index" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/cinemaShow.jsp" style="color: red"><bean:message key="ul.li.cinemaShow" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/filmShow.jsp"><bean:message key="ul.li.filmShow" /></a>
                        <br>
                        <hr class="ulHrCinema">
                    </li>
                </ul>
            </div>
                        <div class="showDiv">
                            <html:form action="/searchCinemaName" method="post">
                                <input type="text" name="searchCinemaNameKey" placeholder="输入你想查询的影院名">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="submit" value="查找">
                            </html:form>
                                <html:form action="/searchCinemaAddr" method="post">
                                <input type="text" name="searchCinemaAddrKey" placeholder="输入你想查询的地址">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="submit" value="查找">
                            </html:form>
                        </div>
                        <%String cinemaId = request.getParameter("cinemaId");
                        CinemaDao cinemaDao = new CinemaDao();
                        if(cinemaId==null){
                            List list = (List)request.getAttribute("list");
                            String tip = String.valueOf(request.getAttribute("tip"));
                            if(tip == "null"){
                                List AllCinemaList = cinemaDao.getAllCinemas();
                                Map map = null;
                                if(AllCinemaList != null){
                                    for(int i = 0; i < AllCinemaList.size(); i++){
                                        map = (Map)AllCinemaList.get(i);%>
                                        <table class="strutsTable">
                                        <tr><td><a href="cinemaShow.jsp?cinemaId=<%=map.get("cinemaId")%>"><%=map.get("cinemaName")%></a></td></tr>
                                        <tr><td>地址： <%=map.get("cinemaAddr")%></td></tr>
                                        <tr><td>电话：<%=map.get("cinemaTel")%></td></tr>
                                        <tr><td>服务详情：<%=map.get("cinemaService")%></td></tr>
                                        </table>
                                    <%}//end for
                                }else{ //if(AllConemaList == null)%>
                                <h1>还没有一家影院提供服务</h1><%}%>
                            <%}else {//if(tip != "null")
if(list.size()!=0){
for(int i = 0; i < list.size(); i++){
                                       Map map = (Map)list.get(i);%>
                                        <table class="strutsTable">
                                        <tr><td><a href="cinemaShow.jsp?cinemaId=<%=map.get("cinemaId")%>"><%=map.get("cinemaName")%></a></td></tr>
                                        <tr><td>地址： <%=map.get("cinemaAddr")%></td></tr>
                                        <tr><td>电话： <%=map.get("cinemaTel")%></td></tr>
                                        <tr><td>服务详情： <%=map.get("cinemaService")%></td></tr>
                                        </table>
                                    <%}
}else if(list.size()==0){%>
<h1>不能查询到相应内容的影院信息</h1>
<%}
}
                        }else if(cinemaId != null){
Cinema cinema = cinemaDao.find1(cinemaId);%>
<h1><%=cinema.getCinemaName()%></h1><br>
<table class="strutsTable">
    <tr>
        <td>地址：</td><td><%=cinema.getCinemaAddr()%></td></tr>
    <tr><td>电话：</td><td><%=cinema.getCinemaTel()%></td></tr>
    <tr><td>服务详情：</td><td><%=cinema.getCinemaService()%></td></tr>
</table>
    <c:if test="${user!=null}">
        <% CinemaFilmDao cinemaFilmDao = new CinemaFilmDao();
        List theFilmList = cinemaFilmDao.getTheFilmOfCinema(cinemaId);
        Map map = null;
        FilmDao filmDao = new FilmDao();
        if(theFilmList!=null&&theFilmList.size()>0){
            for(int i = 0; i < theFilmList.size(); i++){
                map = (Map)theFilmList.get(i);
                Film film = filmDao.getFilm(Integer.parseInt(String.valueOf(map.get("showFilmId"))));%>
                <a href="buy.jsp?cinemaId=<%=cinemaId%>&filmId=<%=film.getFilmId()%>"><%=film.getFilmName()%></a><br>
<table class="strutsTable">
    <tr>
        <td>上映日期：</td><td><%=new SimpleDateFormat("yyyy-MM-dd").format(film.getReleaseDate())%></td></tr>
    <tr><td>时长：</td><td><%=film.getDuration()%>分钟</td></tr>
    <tr><td>剧情概要：</td><td><%=film.getFilmAbstract()%></td></tr>
    <tr><td>导演：</td><td><%=film.getDirective()%></td></tr>
    <tr><td>标签:</td><td><%=StringUtil.filmTagConvert(film.getDurationType())%></td></tr>
</table>
<%            }
        }else if(theFilmList==null || theFilmList.size()==0){%>
        <h1>影院没有正在上映的电影</h1>
        <%}%>
    </c:if>
    <c:if test="${user==null}">
        <h1>请登录以查看更多内容</h1>
    </c:if>
<%}%>
<!--    </body>
</html>-->
