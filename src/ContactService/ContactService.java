package ContactService;

import java.util.ArrayList;

public class ContactService {
    ArrayList<Contact> contacts;

    public ContactService() {
        contacts = new ArrayList<>();
    }

    //Use ContactService to assign contacts unique IDs
    public boolean addContact(Contact newContact) {
        boolean contains = false;
        for(Contact x: contacts) {
            if(x.getContactId().equalsIgnoreCase(newContact.getContactId())) {
                contains = true;
                break;
            }
        }

        if(!contains) {
            contacts.add(newContact);
            return true;
        }
        else {
            return false;
        }
    }

    //Method to remove contacts based on their contact IDs
    public boolean removeContact(String contactID) {
        boolean remove = false;
        for(Contact x: contacts) {
            if(x.getContactId().equalsIgnoreCase((contactID))) {
                contacts.remove(x);
                remove = true;
                break;
            }
        }
        return remove;
    }

    //boolean method that will update the first name associated with the ID
    public boolean replaceFName(String contactID, String newFName) {
        boolean update = false;
        for(Contact x: contacts) {
            if(x.getContactId().equalsIgnoreCase(contactID)) {
                x.setFirstName(newFName);
                update = true;
                break;
            }
        }
        return update;
    }

    //boolean method that will update the last name of the ID
    public boolean replaceLName(String contactID, String newLName) {
        boolean update = false;
        for(Contact x: contacts) {
            if(x.getContactId().equalsIgnoreCase(contactID)) {
                x.setLastName(newLName);
                update = true;
                break;
            }
        }
        return update;
    }

    //boolean function to update address of the ID
    public boolean replaceAddress(String contactID, String newAddress) {
        boolean update = false;
        for(Contact x: contacts) {
            if(x.getContactId().equalsIgnoreCase(contactID)) {
                x.setAddress(newAddress);
                update = true;
                break;
            }
        }
        return update;
    }

    //boolean function to update the contact phone number
    public boolean replacePNum(String contactID, String newPNum) {
        boolean update = false;
        for(Contact x: contacts) {
            if(x.getContactId().equalsIgnoreCase(contactID)) {
                x.setPhoneNum(newPNum);
                update = true;
                break;
            }
        }
        return update;
    }

    //Display the contacts
    public void contactDisplay() {
        for(Contact x: contacts) {
            System.out.println(x.toString());
        }
    }

    public boolean deleteContact(String string) {
        return false;
    }
}

