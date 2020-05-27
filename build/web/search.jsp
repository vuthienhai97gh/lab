<%-- 
    Document   : ps
    Created on : May 20, 2020, 3:14:52 PM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <h1>List Question</h1>
        <form action="ControllerServlet" method="POST">
            <select name="cbCategory">
                <option value="All">
                    ALL
                </option>
            </select><br>
            <c:forEach var="dto" items="${requestScope.LISTQUESTION}">
                <table border="1">
                    <thead>
                        <tr>
                            <th colspan="2">${dto.question_content}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${empty YOURCHOICE}">
                            <tr>
                                <td><input type="radio" name="answer1" value="${answer.get(0).answerChoice}" >${answer.get(0).answerChoice}. ${answer.get(0).answerContent}</td>
                                <td><input type="radio" name="answer1" value="${answer.get(1).answerChoice}" >${answer.get(1).answerChoice}. ${answer.get(1).answerContent}</td>
                            </tr>
                            <tr>
                                <td><input type="radio" name="answer1" value="${answer.get(2).answerChoice}">${answer.get(2).answerChoice}. ${answer.get(2).answerContent}</td>
                                <td><input type="radio" name="answer1" value="${answer.get(3).answerChoice}">${answer.get(3).answerChoice}. ${answer.get(3).answerContent}</td>
                            </tr>  
                        </c:if>
                        <c:if test="${not empty YOURCHOICE}">    
                            <tr>
                                <c:if test="${YOURCHOICE == 'A'}">
                                    <td><input type="radio" name="answer" value="${answer.get(0).answerChoice}" checked="true">${answer.get(0).answerChoice}. ${answer.get(0).answerContent}</td>
                                    </c:if>
                                    <c:if test="${YOURCHOICE == 'B'}">
                                    <td><input type="radio" name="answer" value="${answer.get(1).answerChoice}" checked="true">${answer.get(1).answerChoice}. ${answer.get(1).answerContent}</td>
                                    </c:if>
                            </tr>
                            <tr>
                                <c:if test="${YOURCHOICE == 'C'}">
                                    <td><input type="radio" name="answer" value="${answer.get(2).answerChoice}" checked="true">${answer.get(2).answerChoice}. ${answer.get(2).answerContent}</td>
                                </c:if>
                                <c:if test="${YOURCHOICE == 'D'}">
                                <td><input type="radio" name="answer" value="${answer.get(3).answerChoice}" checked="true">${answer.get(3).answerChoice}. ${answer.get(3).answerContent}</td>
                                </c:if>
                                </tr>
                        </c:if>
                    </tbody>
                </table>
                        <br/>
            </c:forEach>
                        <br/>
                <div style="width: 100%">
                    <c:if test="${currentQuestion != 1}">
                        <input style="align-content: flex-start" type="submit"
                               name="btAction" value="Previous"/>
                    </c:if>
                    <c:if test="${currentQuestion != sessionScope.NUMQUESTION}">
                        <input style="float: right" type="submit" name="btAction" value="Next"/>
                    </c:if>
                </div><br/><br/><br/>
            </form>
    </body>
</html>
