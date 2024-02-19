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
    void get_user_from_userBase_test() {
        assertEquals(getUserById(0).getName(),
                "ADMINUS");
    }

    @Test
    void message_add_and_get() {
        addMessage("hello", getUserById(0));
        addMessage("hello", getUserById(0));
        addMessage("hello", getUserById(0));
        assertEquals(showAllMessages().stream()
                        .map(Message::getValue)
                        .reduce((a, b) -> a + b)
                        .orElse("Empty"),
                "hellohellohello");
    }

    @Test
    void adding_sessionId_test() {
        addSessionId(getUserById(0), "sessionName");
        assertEquals(getUserById(0).getSessionId(), "sessionName");
    }

    @Test
    void removing_sessionId_test() {
        addSessionId(getUserById(0), "sessionName");
        removeSessionId(getUserById(0));
        assertEquals(getUserById(0).getSessionId(), "");
    }

    @Test
    void existing_sessionId_test() {
        addSessionId(getUserById(0), "id");
        assertTrue(isSessionIdExist("id"));
    }
}