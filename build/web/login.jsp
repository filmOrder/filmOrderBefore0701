<%-- 
    Document   : login
    Created on : May 30, 2019, 3:15:55 PM
    Author     : tellw
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>--%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<title><bean:message key="login.title" /></title>
<html:form action="/login">
            <table border="1" class="strutsTable">
                <tbody>
                    <tr>
                        <td><bean:message key="login.id" /></td>
                        <td><html:text property="loginId" /></td>
                        <td class="errorTd"><bean:write name="LoginForm" property="loginIdError" filter="false" /></td>
            </tr>
        <tr>
            <td><bean:message key="buyerRegister.buyerPwd" /></td>
            <td><html:password property="loginPwd" /></td>
<td class="errorTd"><bean:write name="LoginForm" property="loginPwdError" filter="false" /></td>
    </tr>
    </tbody>
</table>
<div>
    <html:radio property="role" value="buyer"><bean:message key="login.radioBuyer" /></html:radio>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <html:radio property="role" value="cinema"><bean:message key="login.radioCinema" /></html:radio>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <bean:write name="LoginForm" property="roleError" filter="false" />
                        </div>
<html:submit value="登录" />
</html:form>
<!--    </body>
</html>-->
