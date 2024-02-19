package org.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.result.ForwardResult;
import org.example.result.Result;
import static org.example.Resources.PAGE_CHAT;

public class EmptyCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        return new ForwardResult(PAGE_CHAT);
    }
}
