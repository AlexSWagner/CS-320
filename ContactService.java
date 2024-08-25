package com.contacts;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            return false;
        }
        contacts.put(contact.getContactID(), contact);
        return true;
    }

    public boolean deleteContact(String contactID) {
        if (contacts.containsKey(contactID)) {
            contacts.remove(contactID);
            return true;
        }
        return false;
    }

    public boolean updateContactFirstName(String contactID, String firstName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;
        }
        contact.setFirstName(firstName);
        return true;
    }

    public boolean updateContactLastName(String contactID, String lastName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;
        }
        contact.setLastName(lastName);
        return true;
    }

    public boolean updateContactPhone(String contactID, String phone) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;
        }
        contact.setPhone(phone);
        return true;
    }

    public boolean updateContactAddress(String contactID, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;
        }
        contact.setAddress(address);
        return true;
    }

    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
