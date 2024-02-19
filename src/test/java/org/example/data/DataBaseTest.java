package org.example.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.data.DataBase.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataBaseTest {

    @BeforeEach
    void setUp() {
        DataBase.userBase.addAll(List.of(
                new User(userId.getAndIncrement(), "admin", "123", "ADMINUS", UserType.ADMIN)));
    }

    @Test
    void get_user_from_userBase_and_getName_test() {
        assertEquals(getUserByLogin("admin").getName(),
                "ADMINUS");
    }
    @Test
    void get_user_from_userBase_and_getUserType_test() {
        assertTrue(getUserByLogin("admin").getUserType().equals(UserType.ADMIN));
    }

    @Test
    void message_add_and_get() {
        addMessage("hello", getUserByLogin("admin"));
        addMessage("hello", getUserByLogin("admin"));
        addMessage("hello", getUserByLogin("admin"));
        assertEquals(showAllMessages().stream()
                        .map(Message::getValue)
                        .reduce((a, b) -> a + b)
                        .orElse("Empty"),
                "hellohellohello");
    }
}