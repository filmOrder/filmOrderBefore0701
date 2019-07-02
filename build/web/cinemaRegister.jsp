<%-- 
    Document   : cinemaRegister
    Created on : May 23, 2019, 12:49:44 PM
    Author     : tellw
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%--<!DOCTYPE html>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/filmOrder.css" type="text/css">--%>
        <title><bean:message key="cinemaRegister.title" /></title>
<!--    </head>
    <body>-->
        <html:form action="/cinemaRegister">
            <table border="1" class="strutsTable">
                <tbody>
                    <tr>
                        <td><bean:message key="buyerRegister.buyerId" /></td>
                        <td><html:text property="cinemaId"/></td>
                        <td class="errorTd"><bean:write name="CinemaRegisterForm" property="cinemaIdError" filter="false" /></td>
            </tr>
            <tr>
                <td><bean:message key="buyerRegister.buyerName" /></td>
                <td><html:text property="cinemaUsrName" /></td>
            <td class="errorTd"><bean:write name="CinemaRegisterForm" property="cinemaUsrNameError" filter="false" /></td>
        </tr>
        <tr>
            <td><bean:message key="buyerRegister.buyerPwd" /></td>
            <td><html:password property="cinemaPwd" /></td>
            <td class="errorTd"><bean:write name="CinemaRegisterForm" property="cinemaPwdError" filter="false" /></td>
    </tr>
    <tr>
        <td><bean:message key="buyerRegister.buyerPwdAgain" /></td>
        <td><html:password property="cinemaPwdAgain" /></td>
        <td class="errorTd"><bean:write name="CinemaRegisterForm" property="cinemaPwdAgainError" filter="false" /></td>
</tr>
<tr>
        <td><bean:message key="cinemaRegister.cinemaName" /></td>
        <td><html:text property="cinemaName" /></td>
        <td class="errorTd"><bean:write name="CinemaRegisterForm" property="cinemaNameError" filter="false" /></td>
</tr>
<tr>
        <td><bean:message key="cinemaRegister.cinemaAddr" /></td>
        <td><html:text property="cinemaAddr" /></td>
        <td class="errorTd"><bean:write name="CinemaRegisterForm" property="cinemaAddrError" filter="false" /></td>
</tr>
<tr>
        <td><bean:message key="cinemaRegister.cinemaTel" /></td>
        <td><html:text property="cinemaTel" /></td>
        <td class="errorTd"><bean:write name="CinemaRegisterForm" property="cinemaTelError" filter="false" /></td>
</tr>
<tr>
        <td><bean:message key="cinemaRegister.cinemaService" /></td>
        <td><html:text property="cinemaService" /></td>
    <td class="errorTd"><bean:write name="CinemaRegisterForm" property="cinemaServiceError" filter="false" /></td>
</tr>
</tbody>
</table>

<html:submit value="注册" />
</html:form>
<!--</body>
</html>-->
