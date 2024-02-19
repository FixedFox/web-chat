package org.example.command;

import org.example.command.action.LoginCommand;
import org.example.command.action.LogoutCommand;
import org.example.command.action.SendMessageCommand;
import org.example.command.action.BanCommand;
import org.example.command.action.UnbanCommand;

import org.example.command.show.ShowChatPageCommand;
import org.example.command.show.ShowLoginPageCommand;
import org.example.command.show.ShowUserPageCommand;

public enum CommandType {
    EMPTY(new EmptyCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    SEND(new SendMessageCommand()),
    BAN(new BanCommand()),
    UNBAN(new UnbanCommand()),

    SHOW_CHAT_PAGE(new ShowChatPageCommand()),
    SHOW_LOGIN_PAGE(new ShowLoginPageCommand()),
    SHOW_USER_PAGE(new ShowUserPageCommand());


    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
