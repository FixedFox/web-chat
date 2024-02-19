package org.example.data;

public class User {

    private final int userId;
    private final String login;
    private final String password;
    private final String name;
    private final UserType userType;
    private boolean online = false;
    private String sessionId;

    public User(int userId,String login, String password, String name, UserType userType) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.userType = userType;
        this.sessionId = "";
    }

    public int getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public String getSessionId() {
        return sessionId;
    }
    public void clearSessionId() {
        this.setSessionId("");
    }
}
