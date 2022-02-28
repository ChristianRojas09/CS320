package ContactService;

//import ContactService.Contact;
//import ContactService.ContactService;

public class ContactServiceTest {
    public static void main(String[] args) {
        ContactService contLog = new ContactService();

        //create contacts
        Contact x01 = new Contact("x01","Tanjiro","Kamado","3458764321","Tokyo Japan");

        //add contact to log
        if(contLog.addContact(x01)) {
            System.out.println("New contact added");
        }
        else {
            System.out.println("Unable to add contact. Please try again");
        }

        System.out.println();
        contLog.contactDisplay();

        //remove contacts
        System.out.println();
        if(contLog.deleteContact("x01")){
            System.out.println("Contact Deleted");
        }
        else {
            System.out.println("Could not delete contact");
        }

        //display contact
        System.out.println();
        contLog.contactDisplay();
    }
}
