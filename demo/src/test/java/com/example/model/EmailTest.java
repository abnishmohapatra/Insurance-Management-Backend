package com.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailTest {

    @Test
    void testGettersAndSetters() {
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setTo("test@example.com");
        emailRequest.setSubject("Test Subject");
        emailRequest.setBody("Test Body");

        assertEquals("test@example.com", emailRequest.getTo());
        assertEquals("Test Subject", emailRequest.getSubject());
        assertEquals("Test Body", emailRequest.getBody());
    }

    @Test
    void testConstructor() {
        EmailRequest emailRequest = new EmailRequest("test@example.com", "Test Subject", "Test Body");

        assertEquals("test@example.com", emailRequest.getTo());
        assertEquals("Test Subject", emailRequest.getSubject());
        assertEquals("Test Body", emailRequest.getBody());
    }

    @Test
    void testToString() {
        EmailRequest emailRequest = new EmailRequest("test@example.com", "Test Subject", "Test Body");

        String expectedToString = "EmailRequest [to=test@example.com, subject=Test Subject, body=Test Body]";
        assertEquals(expectedToString, emailRequest.toString());
    }
}

