<%-- 
    Document   : ps
    Created on : May 20, 2020, 3:14:52 PM
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
        <title>Search</title>
    </head>
    <body>
        <div class="container-fluid">
            <form action="ControllerServlet" method="POST">
                <c:if test="${not empty sessionScope.USERID}">
                    <c:if test="${sessionScope.ROLE == 'ADMIN'}">
                        <font color="red">Welcome, ${sessionScope.ROLE} ${sessionScope.USERID}</font><br/>
                    </c:if>
                    <c:if test="${sessionScope.ROLE != 'ADMIN'}">
                        <font color="blue">
                        Welcome, ${sessionScope.ROLE} ${sessionScope.USERID}
                        </font><br>
                    </c:if>
                    <input class="btn btn-primary" type="submit" value="Logout" name="btAction"><br/>
                </c:if>
            </form>
            <c:if test="${sessionScope.ROLE == 'ADMIN'}">
                <h1>List Question</h1>
                <form action="ControllerServlet" method="POST">

                    Subject: <select name="cbSubject">
                        <option value="0">
                            ALL
                        </option>
                        <option value="1">
                            PRJ321
                        </option>
                        <option value="2">
                            PRJ311
                        </option>
                    </select>

                    Status: <select name="questionStatus">
                        <option value="0" >
                            ALL
                        </option>
                        <option value="1">
                            Active
                        </option>
                        <option value="2">
                            InActive
                        </option>
                    </select><br/><br/>

<!--Search question : <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /><br/>-->
                    <!-- Search form -->
                    <input class="form-control" type="text" placeholder="Search" aria-label="Search" name="txtSearchValue" value="${param.txtSearchValue}"><br/>
                    <input class="btn btn-primary" type="submit" value="Search" name="btAction"><br/><br/>

                    <%--<c:set var="list" scope="session" value="${sessionScope.LISTQUESTION}"/>--%>
                    <c:set var="totalCount" scope="session" value="${sessionScope.LISTQUESTION.size()}"/>

                    <c:set var="perPage" scope="session"  value="5"/>
                    <c:set var="pageStart" value="${param.start}"/>

                    <c:if test="${empty pageStart or pageStart < 0}">
                        <c:set var="pageStart" value="0"/>
                    </c:if>

                    <c:if test="${totalCount < pageStart}">
                        <c:set var="pageStart" value="${pageStart - perPage}"/>
                    </c:if>

                    <c:set var="pageNo" value="${pageStart + 1} - ${pageStart + perPage}"/>

<!--                    <a href="search.jsp?start=${pageStart - perPage}"><<</a>${pageNo}
                    <a href="search.jsp?start=${pageStart + perPage}">>></a>-->

                    <c:forEach var="dto" items="${sessionScope.LISTANSWER}" begin="${pageStart}" end="${pageStart + perPage - 1}" varStatus="counter">
                        <c:set var="answer" value="${dto.value}"/>

                        <form action="ControllerServlet" method="POST">

                            <table border="2" class="table">
                                <thead>
                                    <tr>
                                        <th colspan="2" >
                                            <input type="hidden" name="txtQid" value="${dto.key.id}" />
                                            ${counter.count}. <input type="text" name="txtQuestion" value="${dto.key.question_content}" />
                                        </th>
                                        <th>Answer Correct</th>
                                        <th>Subject</th>
                                        <th>Status</th>
                                        <th>Delete</th>
                                        <th>Update</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>A.<input type="text" name="answerA" value="${answer.get(0).answerContent}" ></td>
                                        <td>B.<input type="text" name="answerB" value="${answer.get(1).answerContent}" ></td>
                                        <td>
                                            <!--<input type="hidden" name="txtAnswerCorrect" value="${dto.key.answer_correct}" />-->
                                            <input type="text" name="txtAnswerCorrect" value="${dto.key.answer_correct}" />
                                        </td>
                                        <td>
                                            ${dto.key.subjectId}
                                        </td>
                                        <td>
                                            ${dto.key.statusName}
                                        </td>
                                        <td>
                                            <c:url var="delLink" value="ControllerServlet">
                                                <c:param name="btAction" value="del"/>
                                                <c:param name="txtQid" value="${dto.key.id}"/>
                                            </c:url>
                                            <a href="${delLink}">Delete</a>
                                        </td>
                                        <td>
                                            <input type="submit" value="Update" name="btAction" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>C.<input type="text" name="answerC" value="${answer.get(2).answerContent}" ></td>
                                        <td>D.<input type="text" name="answerD" value="${answer.get(3).answerContent}" ></td>
                                    </tr>
                                </tbody>
                            </table>
                            <br/>
                        </c:forEach>

                    </form>
                </c:if>
                <c:if test="${sessionScope.ROLE != 'ADMIN'}">
                    <a href="student.jsp">Take Quiz</a>
                </c:if>
                <nav aria-label="Page navigation example" >
                    <ul class="pagination" var>
                        <li class="page-item"><a class="page-link" href="search.jsp?start=${pageStart - perPage}">Previous</a></li>

                        <%--<c:forEach items="${pageNo}" varStatus="numberPages">--%>
                            <li class="page-item"><a class="page-link" href="#">
                                    ${pageNo}
                                </a></li>
                        <%--</c:forEach>--%>

                        <li class="page-item"><a class="page-link" href="search.jsp?start=${pageStart + perPage}">Next</a></li>
                    </ul>
                </nav><br/>
                <a href="createquestion.jsp">Create New Question</a>
        </div>
    </body>
</html>
