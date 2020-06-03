<%-- 
    Document   : createNewAccount
    Created on : May 19, 2020, 11:44:20 AM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" integrity="sha384-1CmrxMRARb6aLqgBO7yyAxTOQE2AKb9GfXnEo760AUcUmFx3ibVJJAzGytlQcNXd" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Account</title>
    </head>
    <body>
        <h1>Create Account</h1>
        <form action="ControllerServlet" method="POST">
            <c:set var="errors" value="${requestScope.INSERTERR}"/>

            <!--Email* <input type="text" name="txtEmail" value="${param.txtEmail}" /><br/>-->
            <div class="form-group">
                <label for="exampleInputEmail1">Email address*</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="txtEmail" value="${param.txtEmail}">
            </div>
            
            <c:if test="${not empty errors.emailErr}">
                <font color="red">
                ${errors.emailErr}
                </font><br/>
            </c:if>
                
            <!--Name* <input type="text" name="txtName" value="${param.txtName}" /><br/>-->
            
            <div class="form-group">
                <label>Name*</label>
                <input type="text" class="form-control" name="txtName" value="${param.txtName}">
            </div>
            
            <c:if test="${not empty errors.nameErr}">
                <font color="red">
                ${errors.nameErr}
                </font><br/>
            </c:if>
                
            <!--Password* <input type="password" name="txtPassword" value="" /><br/>-->
            
            <div class="form-group">
                <label>Password*</label>
                <input type="password" class="form-control" name="txtPassword">
            </div>
            
            <c:if test="${not empty errors.passwordErr}">
                <font color="red">
                ${errors.passwordErr}
                </font><br/>
            </c:if>
            <!--Confirm* <input type="password" name="txtConfirm" value="" /><br/>-->
            
            <div class="form-group">
                <label>Confirm*</label>
                <input type="password" class="form-control" name="txtConfirm">
            </div>
            
            <c:if test="${not empty errors.confirmNotMatch}">
                <font color="red">
                ${errors.confirmNotMatch}
                </font><br/>
            </c:if>
            <!--Is Student <input type="checkbox" name="chkRole" value="" checked="checked" /><br/>-->
            <input type="submit" value="Create New Account" name="btAction" class="btn btn-primary" />
            <input type="reset" value="Reset" class="btn btn-primary" /><br/>
        </form><br/>
        <c:if test="${not empty errors.emailIsExisted}">
            <font color="red">
            ${errors.emailIsExisted}
            </font>
        </c:if>
        <a href="login.jsp">Click here to login page</a>

    </body>
</html>
