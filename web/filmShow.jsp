<%-- 
    Document   : filmShow
    Created on : Jun 8, 2019, 7:44:56 PM
    Author     : tellw
--%>

<%@page import="com.myapp.domain.Cinema"%>
<%@page import="com.myapp.dao.CinemaDao"%>
<%@page import="com.myapp.domain.Room"%>
<%@page import="com.myapp.dao.RoomDao"%>
<%@page import="com.myapp.dao.CinemaFilmDao"%>
<%@page import="com.myapp.dao.BuyerDao"%>
<%@page import="com.myapp.dao.FilmCommentDao"%>
<%@page import="common.util.StringUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.myapp.domain.Film"%>
<%@page import="java.util.Map"%>
<%@page import="com.myapp.dao.FilmDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>--%>
        <%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<title><bean:message key="filmShow.title" /></title>
<%
		if (request.getAttribute("error") != null) {
			out.print("<script>alert('" + request.getAttribute("error") + "');</script>");
		}
	%>
<div id="headerUl">
                <ul>
                    <li>
                        <a class="ulA" href="${pageContext.request.contextPath}/index.jsp"><bean:message key="ul.li.index" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/cinemaShow.jsp"><bean:message key="ul.li.cinemaShow" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/filmShow.jsp" style="color: red"><bean:message key="ul.li.filmShow" /></a>
                        <br>
                        <hr class="ulHrFilm">
                    </li>
                </ul>
            </div>
                        <div class="showDiv">
                            <html:form action="/searchFilmName" method="post">
                                <input type="text" name="searchFilmNameKey" placeholder="输入你想查询的电影名">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="submit" value="查找">
                            </html:form>
                                按电影类型：
                                <input type="button" value="动作" onclick="doSearchFilmAction()">
                                <input type="button" value="喜剧" onclick="doSearchFilmComedy()">
                                <input type="button" value="爱情" onclick="doSearchFilmLove()">
                                <input type="button" value="科幻" onclick="doSearchFilmScience()">
                                <input type="button" value="剧情" onclick="doSearchFilmBook()">
                                <input type="button" value="恐怖" onclick="doSearchFilmTerror()">
                                <input type="button" value="战争" onclick="doSearchFilmWar()">
                                <br>
                                按上映情况：
                                <input type="button" value="正在热映" onclick="doSearchFilmOn()">
                                <input type="button" value="即将上映" onclick="doSearchFilmWill()">
                                <br>
                        </div>
                        <%String filmId = (String)request.getParameter("filmId");
                        FilmDao filmDao = new FilmDao();
                        if(filmId == null){%>
                        <table class="strutsTable"><%
                            List list = (List)request.getAttribute("list");
                            String tip = String.valueOf(request.getAttribute("tip"));
                            if(tip == "null"){
                                List AllFilmList = filmDao.getAllFilms();
                                Map map = null;
                                if(AllFilmList != null){
                                for(int i = 0; i < AllFilmList.size(); i+=3){
                                    %><tr><%if(i < AllFilmList.size()){%><td class="filmTd">
                                            <%map = (Map)AllFilmList.get(i);%>
                                            <a href="${pageContext.request.contextPath}/filmShow.jsp?filmId=<%=""+map.get("filmId")%>"><%=map.get("filmName")%></a>
</td><%}%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%if(i+1 < AllFilmList.size()){%>
<td class="filmTd">
    <%map = (Map)AllFilmList.get(i+1);%>
                                            <a href="${pageContext.request.contextPath}/filmShow.jsp?filmId=<%=""+map.get("filmId")%>"><%=map.get("filmName")%></a>
</td><%}%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%if(i+2 < AllFilmList.size()){%>
<td class="filmTd">
                                            <%map = (Map)AllFilmList.get(i+2);%>
                                            <a href="${pageContext.request.contextPath}/filmShow.jsp?filmId=<%=""+map.get("filmId")%>"><%=map.get("filmName")%></a>
</td><%}%>                                        
</tr>    
                                <%}}%>
                            <%}else{
Map map = null;
if(list.size()!=0){
                                for(int i = 0; i < list.size(); i+=3){
%><tr><%if(i < list.size()){%><td class="filmTd">
                                            <%map = (Map)list.get(i);%>
                                            <a href="${pageContext.request.contextPath}/filmShow.jsp?filmId=<%=""+map.get("filmId")%>"><%=map.get("filmName")%></a>
</td><%}%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%if(i+1 < list.size()){%>
<td class="filmTd">
    <%map = (Map)list.get(i+1);%>
                                            <a href="${pageContext.request.contextPath}/filmShow.jsp?filmId=<%=""+map.get("filmId")%>"><%=map.get("filmName")%></a>
</td><%}%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%if(i+2 < list.size()){%>
<td class="filmTd">
                                            <%map = (Map)list.get(i+2);%>
                                            <a href="${pageContext.request.contextPath}/filmShow.jsp?filmId=<%=""+map.get("filmId")%>"><%=map.get("filmName")%></a>
</td><%}%>                                        
</tr>    
                                <%}}else{%>未查询到结果<%}%>
<%}%></table>
                        <%}else{
Film film = filmDao.getFilm(Integer.parseInt(filmId));%>
<h1><%=film.getFilmName()%></h1><br>
<table class="strutsTable">
    <tr>
        <td>上映日期：</td><td><%=new SimpleDateFormat("yyyy-MM-dd").format(film.getReleaseDate())%></td></tr>
    <tr><td>时长：</td><td><%=film.getDuration()%>分钟</td></tr>
    <tr><td>剧情概要：</td><td><%=film.getFilmAbstract()%></td></tr>
    <tr><td>导演：</td><td><%=film.getDirective()%></td></tr>
    <tr><td>标签:</td><td><%=StringUtil.filmTagConvert(film.getDurationType())%></td></tr>
</table>
    <c:if test="${user!=null}">
        <form action="<%=request.getContextPath()%>/commentPublish.do" method="post">
    <table class="strutsTable">
    <tr>
      <td>发表评论：</td>
      <td><textarea rows="4" cols="50" type="text" name="comment" placeholder="不要超过33字"></textarea></td>
    </tr>
    <tr>
        <td><input type="hidden" name="filmId" value="<%=filmId%>"></td>
      <td><input type="submit" value="发表"></td>
    </tr>
  </table>
</form>
    <%
        int fId = Integer.parseInt(filmId);
                                FilmCommentDao filmCommentDao = new FilmCommentDao();
                                int pageSize = 10;
                                int totalpage = filmCommentDao.countFilmCommentByFilm(fId);
                                int totalpages = filmCommentDao.getTotalPage(pageSize, fId);
                                String currentPage = request.getParameter("pageIndex");
                                if (currentPage == null) {
                                    currentPage = "1";
                                }
                                int pageIndex = Integer.parseInt(currentPage);
                                if (pageIndex < 1) {
                                    pageIndex = 1;
                                } else if (pageIndex > totalpages) {
                                    pageIndex = totalpages;
                                }
                                List list = filmCommentDao.getAllFilmCommentsByPage(pageSize, pageIndex, fId);
                                Map map = null;
                                for (int i = 0; i < list.size(); i++) {
                                    map = (Map) list.get(i);
                        %>
                        <div id="notice">
                        <p id="noticeContent"><%=new BuyerDao().find1((String)map.get("commentBuyerId")).getBuyerName()%>: <%=map.get("comment")%><span id="noticeTime"><%=map.get("filmCommentTime")%></span></p>
                        </div>
                        <%}%>
                        <a href="filmShow.jsp?filmId=<%=filmId%>&pageIndex=1">首页</a>
                        <a href="filmShow.jsp?filmId=<%=filmId%>&pageIndex=<%=pageIndex - 1%>">上一页</a>
                        <a href="filmShow.jsp?filmId=<%=filmId%>&pageIndex=<%=pageIndex + 1%>">下一页</a>
                        <a href="filmShow.jsp?filmId=<%=filmId%>&pageIndex=<%=totalpages%>">末页</a>
                        <div id="filmCinemaInfo">
                            <table>
                                <%CinemaFilmDao cinemaFilmDao = new CinemaFilmDao();
                                List cinemaFilmList = cinemaFilmDao.getCinemaFilmByFilm(Integer.parseInt(filmId));
                                if(cinemaFilmList!=null){
                                    for(int i=0; i<cinemaFilmList.size(); i++){
                                        map = (Map)cinemaFilmList.get(i);
                                        RoomDao roomDao = new RoomDao();
                                        Room room = roomDao.getRoomById(Integer.parseInt(String.valueOf(map.get("showRoomId"))));
                                        String cinemaId = room.getRoomCinemaId();
                                        CinemaDao cinemaDao = new CinemaDao();
                                        Cinema cinema = cinemaDao.find1(cinemaId);
                                %>
                                        <tr><td><a href="buy.jsp?cinemaId=<%=cinemaId%>&filmId=<%=filmId%>"><%=cinema.getCinemaName()%></a></td></tr>
                                        <tr><td><%=cinema.getCinemaAddr()%></td></tr>
                                        <tr><td><%=cinema.getCinemaTel()%></td></tr>
                                        <tr><td><%=cinema.getCinemaService()%></td></tr>
                                        <%if(i==3)break;
                                    }                                  
                                }%>
                            </table>
                        </div>
    </c:if>
    <c:if test="${user==null}">
        <h1>请登录以查看更多内容</h1>
    </c:if>
<%}%>
<!--    </body>
</html>-->
