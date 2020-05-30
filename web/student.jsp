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
        <form action="ControllerServlet" method="POST">
            <font color="red">Welcome, ${sessionScope.USERID}</font>
            <input type="submit" value="Logout" name="btAction" />
        </form>
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
        <c:set var="quiz" value="${sessionScope.QUIZBANK}"/>
        <c:if test="${not empty quiz}">
            <c:set var="listQuestion" value="${quiz.entrySet()}"/>
            Number of question : ${sessionScope.NUMQUESTION}<br/><br/>
            <c:set var="currentQuestion" value="${sessionScope.CURRENTQUESTION}"/>
            Question: ${currentQuestion} / ${sessionScope.NUMQUESTION} <br/>
            <c:set var="question" value="${sessionScope.QUESTION}"/>
            <c:set var="answer" value="${sessionScope.ANSWER}"/>
            <form action="ControllerServlet" method="POST">
                <table border="1">
                    <thead>
                        <tr>
                            <th colspan="2">${currentQuestion} . ${question.questionContent}</th>
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
                </table><br/>
                <div style="width: 100%">
                    <c:if test="${currentQuestion != 1}">
                        <input style="align-content: flex-start" type="submit"
                               name="btAction" value="Previous"/>
                    </c:if>
                    <c:if test="${currentQuestion != sessionScope.NUMQUESTION}">
                        <input style="float: right" type="submit" name="btAction" value="Next"/>
                    </c:if>
                </div><br/>
        </c:if>
    </body>
</html>
