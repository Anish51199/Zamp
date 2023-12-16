package Model;

public class ContactDetails {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public ContactDetails(String firstName, String lastName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}