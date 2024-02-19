<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Чат</title>
        <style>
            .textbox {
                display: block;
                width: 40vw;
                color: white;
                background-color: #007AFF;
                padding: 8px 12px 8px 12px;
                border-radius: 5px;
            }
            .button {
                display: block;
                width: 40vw;
                color: white;
                background-color: #FF3B30;
                padding: 8px 12px 8px 12px;
                border-radius: 5px;
            }
        </style>
        <script>
            const refreshTimer = document.getElementById('refresh-timer');

            let timerInSeconds = 0;

            setInterval(() => {
                timerInSeconds += 1;
                if (timerInSeconds >= 10) {
                    window.location.reload();
                }
            }, 1000);
        </script>

    </head>
    <body>
        <div align="center">
            <form method="GET" action="/chat">
                <button class="button" type="submit" name="command" value="logout">Выйти</button>
            </form>
            <form method="GET" action="/chat">
                <button class="button" type="submit" name="command" value="show_users_page">Пользователи</button>
            </form>
            <!-- Главная страница Чата -->
            <div>
            <c:forEach var="message" items="${messages}">
                <p class="textbox">${message}</p>
            </c:forEach>
            </div>
            <div>
                <form method="POST" action="/chat">
                    <input type="text" name="msg" placeholder="Введитес сообщение" value="">
                    <button type="submit" name="command" value="send">Send</button>
                </form>
            </div>
        </div>
    </body>
</html>