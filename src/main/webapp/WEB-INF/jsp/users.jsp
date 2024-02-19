<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Пользователи</title>
    <style>
        table, th, td {
            border: 1px solid;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Login</th>
        <th>Online</th>
        <th>Ban</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.getName()}"/></td>
            <td><c:out value="${user.getLogin()}"/></td>
            <td><c:out value="${user.isOnline()}"/></td>
            <td>
                <c:if test="${user.isBanned() == true}">
                    <form method="POST" action="/users?command=unban">
                        <button name="login" value="${user.getLogin()}">UnBAN!</button>
                    </form>
                </c:if>
                <c:if test="${user.isBanned() == false}">
                    <form method="POST" action="/users?command=ban">
                        <button name="login" value="${user.getLogin()}">BAN!</button>
                    </form>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<form method="GET" action="/chat">
    <button type="submit" name="command" value="show_chat_page">Вернуться к чату</button>
</form>
</body>
</html>
