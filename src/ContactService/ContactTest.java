package ContactService;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import ContactService.Contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.experimental.theories.suppliers.TestedOn;

public class ContactTest {
    Contact contact = new Contact("x01", "firstName","lastName","1234567890","address");

    @Test
    void getContactId() {
        assertEquals("x01",contact.getContactId());
    }

    @Test
    void getFirstName() {
        assertEquals("x01",contact.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("x01",contact.getLastName());
    }

    @Test
    void getPhoneNum() {
        assertEquals("x01",contact.getPhoneNumber());
    }

    @Test
    void getAddress() {
        assertEquals("x01",contact.getAddress());
    }

    @Test
    void testToString() {
        assertEquals("Contact [contactId=x01, firstName = Tanjiro, lastName = Kamado, phoneNumber = 3458764321, address= Tokyo Japan]", contact.toString());
    }
}
