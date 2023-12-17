package Service;

import Model.ContactDetails;
import Model.TrieNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressBookManager {
    private TrieNode nameTrieRoot;
    private TrieNode phoneTrieRoot;

    public AddressBookManager() {
        this.nameTrieRoot = new TrieNode();
        this.phoneTrieRoot = new TrieNode();
    }

    public void addContact(String firstName, String lastName, String address, String phoneNumber) {
        insertContact(firstName, lastName, address, phoneNumber);
    }

    private void insertContact(String firstName, String lastName, String address, String phoneNumber) {
        // Insert into the name trie
        String nameKey = firstName+lastName;
        TrieNode nameNode = nameTrieRoot;
        insertIntoTrie(nameNode, nameKey, new ContactDetails(firstName, lastName, address, phoneNumber));

        // Insert into the phone trie
        String phoneKey = phoneNumber;
        TrieNode phoneNode = phoneTrieRoot;
        insertIntoTrie(phoneNode, phoneKey, new ContactDetails(firstName, lastName, address, phoneNumber));
    }

    private void insertIntoTrie(TrieNode root, String key, ContactDetails contactDetails) {
        root.getChildren().computeIfAbsent(key.charAt(0), c -> new TrieNode());
        TrieNode node = root.getChildren().get(key.charAt(0));

        for (int i = 1; i < key.length(); i++) {
            char ch = key.charAt(i);
            node.getChildren().computeIfAbsent(ch, c -> new TrieNode());
            node = node.getChildren().get(ch);
        }

        node.setEndOfContact(true);
        node.addContactDetails(contactDetails);
    }

    public List<ContactDetails> searchByName(String firstName, String lastName) {
        TrieNode node = nameTrieRoot;
        String nameKey = firstName+lastName;
        return searchInTrie(node, nameKey);
    }

    public List<ContactDetails> searchByPhoneNumber(String phoneNumber) {
        TrieNode node = phoneTrieRoot;
        return searchInTrie(node, phoneNumber);
    }

    private List<ContactDetails> searchInTrie(TrieNode root, String key) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (!node.getChildren().containsKey(ch)) {
                return Collections.emptyList();
            }
            node = node.getChildren().get(ch);
        }
        return node.getContactDetailsList();
    }

}
