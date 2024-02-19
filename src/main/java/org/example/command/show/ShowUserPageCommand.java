package org.example.command.show;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.command.Command;
import org.example.result.ForwardResult;
import org.example.result.Result;

import static org.example.Resources.PAGE_CHAT;
import static org.example.Resources.PAGE_USERS;
import static org.example.data.DataBase.showAllUsers;

public class ShowUserPageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        if ((boolean) request.getSession().getAttribute("isAdmin")) {
            request.getSession().setAttribute("users", showAllUsers());
            return new ForwardResult(PAGE_USERS);
        } else {
            return new ForwardResult(PAGE_CHAT);
        }
    }
}
