package org.example.data;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class DataBase {
    static CopyOnWriteArrayList<User> userBase = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<Message> messages = new CopyOnWriteArrayList<>();
    static AtomicInteger userId = new AtomicInteger(0);
    private static final AtomicInteger messageId = new AtomicInteger(0);

    public static void init() {
        System.out.println("Установка соединения с Базой Данных");
        userBase.addAll(List.of(
                new User(userId.getAndIncrement(), "admin", "123", "ADMINU$", UserType.ADMIN),
                new User(userId.getAndIncrement(), "fox", "1", "F0XXX", UserType.CLIENT),
                new User(userId.getAndIncrement(), "dog", "2", "D()GGY", UserType.CLIENT),
                new User(userId.getAndIncrement(), "cat", "3", "cAtTy", UserType.CLIENT),
                new User(userId.getAndIncrement(), "fish", "4", "OCEANFISH", UserType.CLIENT)));
        addMessage("Hello to all from ADMINU$", getUserByLogin("admin"));
    }



    public static List<User> showAllUsers() {
        return userBase.stream().sorted().collect(Collectors.toList());
    }

    public static void addMessage(String value, User user) {
        messages.add(new Message(messageId.getAndIncrement(), value, user));
    }

    public static List<Message> showAllMessages() {
        return messages.stream().sorted().collect(Collectors.toList());
    }

    public static boolean checkPassword(String login, String password) {
        return userBase.stream()
                .filter(o -> o.getLogin().equals(login))
                .anyMatch(o -> o.getPassword().equals(password));
    }

    public static User getUserByLogin(String login) {
        return  userBase.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(userBase.get(0));
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }
}
