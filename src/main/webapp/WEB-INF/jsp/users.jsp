<%--
  Created by IntelliJ IDEA.
  User: fixedfox
  Date: 19.02.2024
  Time: 02:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<table>
    <thead>
    <tr>User.ID</tr>
    <tr>User.Name</tr>
    <tr>User.Login</tr>
    <tr>User.isOnline</tr>
    <tr>User.isBanned</tr>
    <tr>User.buttonToBan</tr>
    </thead>
<c:forEach var="users" items="users">
</c:forEach>
</table>
</body>
</html>
