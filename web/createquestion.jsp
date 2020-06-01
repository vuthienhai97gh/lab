<%-- 
    Document   : createquestion
    Created on : Jun 1, 2020, 6:16:58 PM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" integrity="sha384-1CmrxMRARb6aLqgBO7yyAxTOQE2AKb9GfXnEo760AUcUmFx3ibVJJAzGytlQcNXd" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Question Page</title>
    </head>
    <body>
        <h1>Create Question</h1>
        <form action="ControllerServlet" method="POST">
            Question Content* <input type="text" name="txtQuestionContent" value="${param.txtQuestionContent}" /><br/>
            Answer Content<br/>
            A* <input type="text" name="answerA" value="${param.txtAnswerA}" /><br/>
            B* <input type="text" name="answerB" value="${param.txtAnswerB}" /><br/>
            C* <input type="text" name="answerC" value="${param.txtAnswerC}" /><br/>
            D* <input type="text" name="answerD" value="${param.txtAnswerD}" /><br/>
            Answer Correct* <input type="text" name="txtAnswerCorrect" value="${param.txtAnswerCorrect}" /><br/>
            Subject* <select name="subjectId">
                <option value="1">
                    PRJ321
                </option>
                <option value="2">
                    PRJ311
                </option>
            </select><br/>
            Status* <input type="text" name="questionStatus" value="${param.questionStatus}" /><br/>
            <input class="btn btn-primary" type="submit" value="Create New Question" name="btAction"><br/>
            <a href="search.jsp">Back to search</a>
        </form>
    </body>
</html>
