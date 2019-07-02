<%-- 
    Document   : login
    Created on : May 21, 2019, 11:57:16 PM
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
        <title><bean:message key="buyerRegister.title" /></title>
<!--    </head>
    <body>-->
<div>
        <html:form action="/buyerRegister">
            <table border="1" class="strutsTable">
                <tbody>
                    <tr>
                        <td><bean:message key="buyerRegister.buyerId" /></td>
                        <td><html:text property="buyerId" /></td>
                <td class="errorTd"><bean:write name="BuyerRegisterForm" property="buyerIdError" filter="false" /></td>
            </tr>
            <tr>
                <td><bean:message key="buyerRegister.buyerName" /></td>
                <td><html:text property="buyerName" /></td>
            <td class="errorTd"><bean:write name="BuyerRegisterForm" property="buyerNameError" filter="false" /></td>
        </tr>
        <tr>
            <td><bean:message key="buyerRegister.buyerPwd" /></td>
            <td><html:password property="buyerPwd" /></td>
            <td class="errorTd"><bean:write name="BuyerRegisterForm" property="buyerPwdError" filter="false" /></td>
    </tr>
    <tr>
        <td><bean:message key="buyerRegister.buyerPwdAgain" /></td>
        <td><html:password property="buyerPwdAgain" /></td>
    <td class="errorTd"><bean:write name="BuyerRegisterForm" property="buyerPwdAgainError" filter="false" /></td>
</tr>
</tbody>
</table>

<html:submit value="注册" />
</html:form>
</div>
<!--</body>
</html>-->
