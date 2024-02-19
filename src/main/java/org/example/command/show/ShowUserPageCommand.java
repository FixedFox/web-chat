package org.example.command.show;

import org.example.command.Command;
import org.example.result.ForwardResult;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.PAGE_USERS;
import static org.example.data.DataBase.showAllUsers;

public class ShowUserPageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("users", showAllUsers());
        return new ForwardResult(PAGE_USERS);
    }
}
