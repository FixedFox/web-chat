package org.example.command.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.UserType;
import org.example.result.RedirectResult;
import org.example.result.Result;
import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        // Ваша реализация выполнения входа в Чат
        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");
        HttpSession session = request.getSession();

        if (DataBase.checkPassword(login, password)) {
            session.setAttribute("user", DataBase.getUserByLogin(login));
            DataBase.getUserByLogin(login).setOnline(true);
            session.setAttribute("isAdmin", DataBase.getUserByLogin(login)
                            .getUserType().equals(UserType.ADMIN));
            session.setAttribute("isBanned", DataBase.getUserByLogin(login).isBanned());
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
        } else {
            request.getSession().setAttribute("errorLoginMessage", "Неепрвильное имя или пароль");
            return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
        }
    }
}
