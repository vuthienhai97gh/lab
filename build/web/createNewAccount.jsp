<%-- 
    Document   : createNewAccount
    Created on : May 19, 2020, 11:44:20 AM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Account</title>
    </head>
    <body>
        <h1>Create Account</h1>
        <form action="ControllerServlet" method="POST">
            Email* <input type="text" name="txtEmail" value="${param.txtEmail}" /><br/>
            <c:set var="errors" value="${requestScope.INSERTERR}"/>
            <c:if test="${not empty errors.emailErr}">
                <font color="red">
                ${errors.emailErr}
                </font><br/>
            </c:if>
            Name* <input type="text" name="txtName" value="${param.txtName}" /><br/>
            <c:if test="${not empty errors.nameErr}">
                <font color="red">
                ${errors.nameErr}
                </font><br/>
            </c:if>
            Password* <input type="password" name="txtPassword" value="" /><br/>
            <c:if test="${not empty errors.passwordErr}">
                <font color="red">
                ${errors.passwordErr}
                </font><br/>
            </c:if>
            Confirm* <input type="password" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty errors.confirmNotMatch}">
                <font color="red">
                ${errors.confirmNotMatch}
                </font><br/>
            </c:if>
            <!--Is Student <input type="checkbox" name="chkRole" value="" checked="checked" /><br/>-->
            <input type="submit" value="Create New Account" name="btAction" />
            <input type="reset" value="Reset" /><br/>
        </form><br/>
        <c:if test="${not empty errors.emailIsExisted}">
            <font color="red">
            ${errors.emailIsExisted}
            </font>
        </c:if>
        <a href="login.jsp">Click here to login page</a>

    </body>
</html>
