<%-- 
    Document   : me
    Created on : Jun 13, 2019, 1:34:04 AM
    Author     : tellw
--%>

<%@page import="com.myapp.dao.BuyerDao"%>
<%@page import="com.myapp.dao.FilmDao"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.myapp.dao.FilmCommentDao"%>
<%@page import="com.myapp.domain.Buyer"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<title><bean:message key="me.title" /></title>
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
<%
    Buyer buyer = (Buyer)session.getAttribute("user");
            String buyerId = buyer.getBuyerId();
BuyerDao buyerDao = new BuyerDao();
int buyerMoney = buyerDao.find1(buyerId).getBuyerMoney();%>
<h1>我的余额:<%=buyerMoney%></h1>
<form action="${pageContext.request.contextPath}/buyerMoneyAdd.do" method="post">
    <table class="strutsTable">
        <tr><td><input type="number" name="addedBuyerMoney"></td><td><input type="hidden" value="<%=buyerId%>" name="buyerId"><input type="submit" value="充值"></td></tr>
    </table>  
</form>

        <h1>我的评论</h1>
        <table class="strutsTable">
            <%
            FilmCommentDao filmCommentDao = new FilmCommentDao();
            List myCommentList = filmCommentDao.getAllFilmCommentByBuyer(buyerId);
            Map map = null;
            if(myCommentList!=null&&myCommentList.size()>0){
                for(int i = 0; i<myCommentList.size(); i++){
                    map = (Map)myCommentList.get(i);%>
                    <tr><td><%=new FilmDao().getFilm(Integer.parseInt(String.valueOf(map.get("filmId")))).getFilmName()%></td><td><%=map.get("comment")%></td><td><%=map.get("filmCommentTime")%></td></tr>
                    <%}
            }else if(myCommentList == null || myCommentList.size()==0){%>
            <h1>您还没有过评论</h1>
<%}%>
        </table>
</c:if>
        <c:if test="${user==null}">
            <h1>请登录</h1>
        </c:if>
<!--    </body>
</html>-->
