import Model.ContactDetails;
import Service.AddressBookManager;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AddressBookManager addressBook = new AddressBookManager();

        // Adding mock data
        for (int i = 0; i < 1000000; i++) {
            String firstName = "FirstName" + i;
            String lastName = "LastName" + i;
            String address = "Address" + i;
            String phoneNumber = "PhoneNumber" + i;

            addressBook.addContact(firstName, lastName, address, phoneNumber);
        }

        //  Dummy Code to just warming up JVM
        for(int i=0;i<10;i++)
        {
            List<ContactDetails> result = addressBook.searchByName("FirstName1");
        }

        // Searching by first name
        long startTime = System.currentTimeMillis();
        List<ContactDetails> resultByName = addressBook.searchByName("FirstName1");
        long endTime = System.currentTimeMillis();

        System.out.println("\nSearch by first name result: " + formatContactDetails(resultByName));
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

        // Searching by PhoneNumber
        long startTime1 = System.currentTimeMillis();
        List<ContactDetails> resultByPhoneNumber = addressBook.searchByPhoneNumber("PhoneNumber5");
        long endTime1= System.currentTimeMillis();

        System.out.println("\nSearch by Phone result: " + formatContactDetails(resultByPhoneNumber));
        System.out.println("Time taken: " + (endTime1 - startTime1) + " milliseconds");

    }

    private static String formatContactDetails(List<ContactDetails> contactDetailsList) {
        if (contactDetailsList.isEmpty()) {
            return "Not Found";
        } else {
            StringBuilder result = new StringBuilder();
            for (ContactDetails contactDetails : contactDetailsList) {
                result.append("First Name: ").append(contactDetails.getFirstName())
                        .append(", Last Name: ").append(contactDetails.getLastName())
                        .append(", Address: ").append(contactDetails.getAddress())
                        .append(", Phone Number: ").append(contactDetails.getPhoneNumber())
                        .append("\n");
            }
            return result.toString();
        }
    }
}