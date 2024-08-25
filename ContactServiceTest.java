package com.contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "Alex", "Wagner", "1234567890", "123 ABC St.");
        assertTrue(service.addContact(contact));
        assertFalse(service.addContact(contact));  // Duplicate contact ID should fail
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "Alex", "Wagner", "1234567890", "123 ABC St.");
        service.addContact(contact);
        assertTrue(service.deleteContact("1234567890"));
        assertFalse(service.deleteContact("1234567890"));  // Contact already deleted
    }

    @Test
    public void testUpdateContactFirstName() {
        Contact contact = new Contact("1234567890", "Alex", "Wagner", "1234567890", "123 ABC St.");
        service.addContact(contact);
        assertTrue(service.updateContactFirstName("1234567890", "Alexa"));
        assertEquals("Alexa", service.getContact("1234567890").getFirstName());
    }

    @Test
    public void testUpdateContactLastName() {
        Contact contact = new Contact("1234567890", "Alex", "Wagner", "1234567890", "123 ABC St.");
        service.addContact(contact);
        assertTrue(service.updateContactLastName("1234567890", "Wagmen"));
        assertEquals("Wagmen", service.getContact("1234567890").getLastName());
    }

    @Test
    public void testUpdateContactPhone() {
        Contact contact = new Contact("1234567890", "Alex", "Wagner", "1234567890", "123 ABC St.");
        service.addContact(contact);
        assertTrue(service.updateContactPhone("1234567890", "0987654321"));
        assertEquals("0987654321", service.getContact("1234567890").getPhone());
    }

    @Test
    public void testUpdateContactAddress() {
        Contact contact = new Contact("1234567890", "Alex", "Wagner", "1234567890", "123 ABC St.");
        service.addContact(contact);
        assertTrue(service.updateContactAddress("1234567890", "321 ABC St."));
        assertEquals("321 ABC St.", service.getContact("1234567890").getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        assertFalse(service.updateContactFirstName("9999999999", "NonExistent"));
        assertFalse(service.updateContactLastName("9999999999", "NonExistent"));
        assertFalse(service.updateContactPhone("9999999999", "0000000000"));
        assertFalse(service.updateContactAddress("9999999999", "No Address"));
    }
}
