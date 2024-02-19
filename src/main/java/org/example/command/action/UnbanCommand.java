package org.example.command.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.command.Command;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;
import static org.example.Resources.PAGE_USERS;
import static org.example.data.DataBase.getUserByLogin;

public class UnbanCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        if ((boolean) request.getSession().getAttribute("isAdmin")) {
            User user = getUserByLogin(request.getParameter("login"));
            user.setBanned(false);
        }
        return new ForwardResult(PAGE_USERS);
    }
}
