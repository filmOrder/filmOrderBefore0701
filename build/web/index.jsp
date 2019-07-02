<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.myapp.dao.NoticeDao"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<title><bean:message key="index.title" /></title>
<div id="headerUl">
                <ul>
                    <li>
                        <a class="ulA" href="${pageContext.request.contextPath}/index.jsp" style="color: red"><bean:message key="ul.li.index" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/cinemaShow.jsp"><bean:message key="ul.li.cinemaShow" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="ulA" href="${pageContext.request.contextPath}/filmShow.jsp"><bean:message key="ul.li.filmShow" /></a>
                        <br>
                        <hr class="ulHrIndex">
                    </li>
                </ul>
            </div>
<%--<jsp:forward page="Welcome.do"/>--%>
<div id="notice">
    <%NoticeDao noticeDao = new NoticeDao();
    List list = noticeDao.getRecentNotice();
                                Map map = null;
                                for (int i = 0; i < list.size(); i++) {
                                    map = (Map) list.get(i);%>
                    <p id="noticeContent">* <%=map.get("noticeContent")%>
                                    <%--<%=new SimpleDateFormat("yyyy-MM-dd  HH:mm").format(new Date((Timestamp)map.get("noticeTime").getTime()))%>--%>
                                    <span id="noticeTime"><%=map.get("noticeTime")%></span></p>
                                    <%}%>
</div>

