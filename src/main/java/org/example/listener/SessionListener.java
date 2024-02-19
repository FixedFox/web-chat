package org.example.listener;

import org.example.data.User;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("sessionCreated");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        User sessionUser = (User) event.getSession().getAttribute("user");

        if (sessionUser != null) {
            sessionUser.setOnline(false);
            System.out.println("Были очищены данные сессии для клиента - " + sessionUser.getName());
        }
    }
}
