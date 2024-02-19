package org.example.command.show;

import org.example.command.Command;
import org.example.data.Message;
import org.example.data.DataBase;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.concurrent.CopyOnWriteArrayList;

import static org.example.Resources.PAGE_CHAT;

public class ShowChatPageCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        // Ваша реализация наполнения данными главной страницы чата
        request.setAttribute("messages", DataBase.showAllMessages());

        return new ForwardResult(PAGE_CHAT);
    }
}
