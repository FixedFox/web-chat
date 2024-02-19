package org.example.data;

import java.util.Date;

public class Message implements Comparable<Message> {
    private final Integer id;
    private final String value;
    private final String userName;
    private final Date time;

    public Message(Integer id, String value, User user) {
        this.id = id;
        this.value = value;
        this.userName = user.getName();
        this.time = new Date();
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(Message o) {
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return value + " :" + time + " от: " + userName;
    }
}
