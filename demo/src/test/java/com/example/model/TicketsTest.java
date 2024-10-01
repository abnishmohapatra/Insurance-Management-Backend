package com.example.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketsTest {

    private Tickets tickets;

    @BeforeEach
    public void setUp() {
        tickets = new Tickets();
    }

    @Test
    public void testIdGetterAndSetter() {
        Long id = 1L;
        tickets.setId(id);
        assertEquals(id, tickets.getId());
    }

    @Test
    public void testTitleGetterAndSetter() {
        String title = "Test Title";
        tickets.setTitle(title);
        assertEquals(title, tickets.getTitle());
    }

    @Test
    public void testDescriptionGetterAndSetter() {
        String description = "Test Description";
        tickets.setDescription(description);
        assertEquals(description, tickets.getDescription());
    }

    @Test
    public void testResponseTxtGetterAndSetter() {
        String responseTxt = "Test Response";
        tickets.setResponseTxt(responseTxt);
        assertEquals(responseTxt, tickets.getResponseTxt());
    }

    @Test
    public void testResponseAtGetterAndSetter() {
        LocalDateTime responseAt = LocalDateTime.now();
        tickets.setResponseAt(responseAt);
        assertEquals(responseAt, tickets.getResponseAt());
    }

    @Test
    public void testUserGetterAndSetter() {
        User user = new User(); // Assuming User class is properly defined
        tickets.setUser(user);
        assertEquals(user, tickets.getUser());
    }

    @Test
    public void testIdIsNullInitially() {
        assertNull(tickets.getId());
    }

    @Test
    public void testUserIsNullInitially() {
        assertNull(tickets.getUser());
    }
}

