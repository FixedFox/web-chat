package org.example.command.show;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.command.Command;
import org.example.result.ForwardResult;
import org.example.result.Result;
import static org.example.Resources.PAGE_LOGIN;

public class ShowLoginPageCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        return new ForwardResult(PAGE_LOGIN);
    }
}
