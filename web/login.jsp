<%-- 
    Document   : login
    Created on : May 19, 2020, 11:43:32 AM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="ControllerServlet" method="POST">
            Email <input type="text" name="txtEmail" value="" /> <br/>
            Password: <input type="password" name="txtPassword" value="" /><br/>
            <input type="submit" value="Login" name="btAction" />
            <input type="reset" value="Reset" /><br/>
        </form>
        <a href="createNewAccount.jsp">Click here to Sign Up</a>
    </body>
</html>
