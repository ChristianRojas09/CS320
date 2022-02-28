package ContactService;

public class Contact {
    //variables
    private String contactID;
    private String phoneNum;
    private String Address;
    private String firstName;
    private String lastName;

    //set the 5 constructors
    public Contact(String contactId, String fName, String lName, String address, String pNum) {

        if(contactId.length() <= 10 && contactId != null) {
            this.contactID = contactId;
        }

        this.firstName = fName;
        this.lastName = lName;
        this.Address = address;
        this.phoneNum = pNum;
    }

    //set the first name
    public void setFirstName(String fName) {
        if(fName.length() <= 10 && fName != null) { //Do not allow first name over 10 characters - does not accept null
            this.firstName = fName; //assign to fName
        }
    }

    //set the last name
    public void setLastName(String lName) {
        if(lName.length() <= 10 && lName != null) { //Do not allow last name over 10 characters - does not accept null
            this.lastName = lName; //assign to lName
        }
    }
        //set the address
        public void setAddress(String address) {
            if(address.length() <= 30 && address != null) { //accept no more than 30 characters - does not accept null
                this.Address = address; //assign to pNum
            }
        }

    //set the phone number
    public void setPhoneNum(String pNum) {
        if(pNum.length() <= 10 && pNum != null) { //standard 10 digit phone number - does not accept null
            this.phoneNum = pNum; //assign to pNum
        }
    }

    // return input from getter methods to their matching variables
    public String getContactId() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return phoneNum;
    }

    @Override
    public String toString() {
        return "Contact [contactID = "+ contactID + 
        ", firstName = " + firstName + 
        ", lastName = " + lastName +
        ", phoneNum = " + phoneNum +
        ", address = " + Address + "]";
    }

}
