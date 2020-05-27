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
        <form action="ControllerServlet" method="POST">
            <font color="red">Welcome, ${sessionScope.USERID}</font>
            <input type="submit" value="Logout" name="btAction" />
        </form>
        <h1>List Question</h1>
        <form action="ControllerServlet" method="POST">
            Search question : <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /><br/>

            Subject: <select name="cbCategory">
                <option value="All">
                    ALL
                </option>
                <option value="PRJ311">
                    PRJ311
                </option>
                <option value="PRJ321">
                    PRJ321
                </option>
            </select>

            Status: <select name="cbStatus">
                <option value="ALL">
                    ALL
                </option>
                <option value="ON">
                    ON
                </option>
                <option value="OFF" >
                    OFF
                </option>
            </select>

            <c:forEach var="dto" items="${requestScope.LISTQUESTION}" varStatus="counter">
                <form action="ControllerServlet" method="POST">

                    <table border="2">
                        <thead>
                            <tr>
                                <th colspan="2">
                                    ${counter.count}. <input type="text" name="txtQuestion" value="${dto.question_content}" />
                                </th>
                                <th>Answer Correct</th>
                                <th>Status</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>A.<input type="text" name="answerA" value="" ></td>
                                <td>B.<input type="text" name="answerB" value="" ></td>
                                <td>
                                    
                                    <input type="text" name="txtAnserCorrect" value="${dto.answer_correct}" />
                                </td>
                                <td>
                                    <input type="text" name="txtStatus" value="${dto.status}" />
                                                                    </td>
                                <td>
                                    <c:url var="delLink" value="ControllerServlet">
                                        <c:param name="btAction" value="del"/>
                                        <c:param name="pk" value="${dto.id}"/>
                                    </c:url>
                                    <a href="${delLink}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btAction" />
                                    <input type="hidden" value="${param.id}" />
                                </td>
                            </tr>
                            <tr>
                                <td>C.<input type="text" name="answerC" value="" ></td>
                                <td>D.<input type="text" name="answerD" value="" ></td>
                            </tr>
                        </tbody>
                    </table>
                    <br/>
                </form>
            </c:forEach>
        </form>
    </body>
</html>
