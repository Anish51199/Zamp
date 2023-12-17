import Model.ContactDetails;
import Service.AddressBookManager;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    private static String getRandomElement(String[] array) {
        int randomIndex = ThreadLocalRandom.current().nextInt(array.length);
        return array[randomIndex];
    }

    public static void main(String[] args) {
        AddressBookManager addressBook = new AddressBookManager();

        // Adding mock data

        String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Eva", "John", "Blake", "Tim"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "June", "Zake", "Dave" };
        String[] addresses = {"123 Main St", "456 Oak Ave", "789 Pine Blvd", "101 Elm Dr", "202 Maple Ln", "Street Road 11"};

        for (int i = 0; i < 1000000; i++) {
            String firstName = getRandomElement(firstNames);
            String lastName = getRandomElement(lastNames);
            String address = getRandomElement(addresses);
            String phoneNumber = "Ph"+i;

            addressBook.addContact(firstName, lastName, address, phoneNumber);
        }


        // Searching by first name
        long startTime = System.currentTimeMillis();
        List<ContactDetails> resultByName = addressBook.searchByName("Alice","Johnson");
        long endTime = System.currentTimeMillis();

        System.out.println("\nSearch by first name result: " + formatContactDetails(resultByName));
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

        // Searching by PhoneNumber
        long startTime1 = System.currentTimeMillis();
        List<ContactDetails> resultByPhoneNumber = addressBook.searchByPhoneNumber("Ph5");
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