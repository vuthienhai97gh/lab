<%-- 
    Document   : student
    Created on : May 28, 2020, 8:55:26 AM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Quiz Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.ROLE != 'ADMIN'}">
                <font color="blue">
                Welcome, ${sessionScope.USERID}
                </font><br>
            </c:if>
    </body>
</html>
