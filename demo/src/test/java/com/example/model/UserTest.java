package com.example.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {

    @Test
    void testGettersAndSetters() {
        User user = new User();
        user.setUserId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setDob(LocalDate.of(1990, 1, 1));
        user.setPhoneNo("1234567890");
        user.setEmailId("john.doe@example.com");
        user.setAddress("123 Main St");
        user.setPassword("password123");
        user.setRole("admin");

        assertEquals(1L, user.getUserId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(LocalDate.of(1990, 1, 1), user.getDob());
        assertEquals("1234567890", user.getPhoneNo());
        assertEquals("john.doe@example.com", user.getEmailId());
        assertEquals("123 Main St", user.getAddress());
        assertEquals("password123", user.getPassword());
        assertEquals("admin", user.getRole());
    }

    @Test
    void testConstructor() {
        User user = new User(1L, "John", "Doe", LocalDate.of(1990, 1, 1), "1234567890", "john.doe@example.com", "123 Main St", "password123", "admin");

        assertEquals(1L, user.getUserId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(LocalDate.of(1990, 1, 1), user.getDob());
        assertEquals("1234567890", user.getPhoneNo());
        assertEquals("john.doe@example.com", user.getEmailId());
        assertEquals("123 Main St", user.getAddress());
        assertEquals("password123", user.getPassword());
        assertEquals("admin", user.getRole());
    }

    @Test
    void testNoArgsConstructor() {
        User user = new User();
        assertNotNull(user);
    }

    @Test
    void testToString() {
        User user = new User(1L, "John", "Doe", LocalDate.of(1990, 1, 1), "1234567890", "john.doe@example.com", "123 Main St", "password123", "admin");
        
        String expectedToString = "User [userId=1, firstName=John, lastName=Doe, dob=1990-01-01, phoneNo=1234567890, emailId=john.doe@example.com, address=123 Main St, password=password123, role=admin]";
        assertEquals(expectedToString, user.toString());
    }
}
