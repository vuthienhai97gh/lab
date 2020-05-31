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
        <font color="red">Welcome, ${sessionScope.USERID}</font>
        <c:set var="listSubject" value="${sessionScope.SUBJECT}"/>
        <c:if test="${not empty listSubject}">
            <form action="ControllerServlet" method="POST">
                Subject: <select name="subjectId">
                    <c:forEach var="item" items="${listSubject}">
                        <option value="${item.subjectId}">${item.subjectName}</option>
                    </c:forEach>
                </select><br/>
                <input type="submit" value="Take Quiz" name="btAction" />
            </form><br/>
        </c:if>
    </body>
</html>
