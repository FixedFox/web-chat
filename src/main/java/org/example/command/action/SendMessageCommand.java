package org.example.command.action;

import org.example.command.Command;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.data.DataBase.addMessage;

public class SendMessageCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        String messageText = request.getParameter("msg");
        addMessage(messageText, user);
        return new ForwardResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
