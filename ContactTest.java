package com.contacts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "Alex", "Wagner", "1234567890", "123 ABC St.");
        assertEquals("1234567890", contact.getContactID());
        assertEquals("Alex", contact.getFirstName());
        assertEquals("Wagner", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 ABC St.", contact.getAddress());
    }

    @Test
    public void testInvalidContactCreation() {
        // Test null contact ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Alex", "Wagner", "1234567890", "123 ABC St.");
        });
        // Test too long contact ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Alex", "Wagner", "1234567890", "123 ABC St.");
        });
    }

    @Test
    public void testInvalidFirstName() {
        // Test null first name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Wagner", "1234567890", "123 ABC St.");
        });
        // Test too long first name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "AlexanderAlexander", "Wagner", "1234567890", "123 ABC St.");
        });
    }

    @Test
    public void testInvalidLastName() {
        // Test null last name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alex", null, "1234567890", "123 ABC St.");
        });
        // Test too long last name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alex", "WagnerWagnerWagner", "1234567890", "123 ABC St.");
        });
    }

    @Test
    public void testInvalidPhone() {
        // Test null phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alex", "Wagner", null, "123 ABC St.");
        });
        // Test too short phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alex", "Wagner", "123456789", "123 ABC St.");
        });
        // Test too long phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alex", "Wagner", "12345678901", "123 ABC St.");
        });
    }

    @Test
    public void testInvalidAddress() {
        // Test null address
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alex", "Wagner", "1234567890", null);
        });
        // Test too long address
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alex", "Wagner", "1234567890", "This address is definitely way too long to be accepted as valid address input by the system.");
        });
    }

    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("1234567890", "Alex", "Wagner", "1234567890", "123 ABC St.");
        // Valid first name change
        contact.setFirstName("Alexa");
        assertEquals("Alexa", contact.getFirstName());

        // Test null first name
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null); // Invalid name
        });

        // Test too long first name
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("AlexanderAlexander"); // Name too long
        });
    }

    @Test
    public void testSetLastName() {
        Contact contact = new Contact("1234567890", "Alex", "Wagner", "1234567890", "123 ABC St.");
        contact.setLastName("Wagmen");
        assertEquals("Wagmen", contact.getLastName());

        // Test null last name
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null); // Invalid last name
        });

        // Test too long last name
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("WagnerWagnerWagner"); // Last name too long
        });
    }

    @Test
    public void testSetPhone() {
        Contact contact = new Contact("1234567890", "Alex", "Wagner", "1234567890", "123 ABC St.");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());

        // Test null phone number
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null); // Invalid phone number
        });

        // Test too short phone number
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("098765432"); // Invalid phone number
        });

        // Test too long phone number
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("09876543211"); // Phone number too long
        });
    }

    @Test
    public void testSetAddress() {
        Contact contact = new Contact("1234567890", "Alex", "Wagner", "1234567890", "123 ABC St.");
        contact.setAddress("321 ABC St.");
        assertEquals("321 ABC St.", contact.getAddress());

        // Test null address
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null); // Invalid address
        });

        // Test too long address
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This address is definitely way too long to be accepted as valid address input by the system."); // Address too long
        });
    }
}
