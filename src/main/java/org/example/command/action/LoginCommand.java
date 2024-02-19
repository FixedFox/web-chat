package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.UserType;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;
import static org.example.data.DataBase.*;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        // Ваша реализация выполнения входа в Чат
        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");

        if (checkPassword(login,password)) {
            request.getSession().setAttribute("user", getUserByLogin(login));
            getUserByLogin(login).setOnline(true);
            request.getSession().setAttribute("isAdmin", getUserByLogin(login).getUserType().equals(UserType.ADMIN));
            request.getSession().setAttribute("isBanned", false);
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);

        } else {
            System.out.println("Login fail");
            request.getSession().setAttribute("errorLoginMessage", "Неепрвильное имя или пароль");
            return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
        }
    }
}
