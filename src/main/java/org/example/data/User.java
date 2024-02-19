package org.example.data;

public class User implements Comparable<User> {

    private final Integer userId;
    private final String login;
    private final String password;
    private final String name;
    private final UserType userType;
    private boolean online = false;
    private boolean isBanned = false;

    public User(Integer userId, String login, String password, String name, UserType userType) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.userType = userType;
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

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    @Override
    public int compareTo(User o) {
        return userId.compareTo(o.userId);
    }
}
