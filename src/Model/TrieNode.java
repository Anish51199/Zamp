package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isEndOfContact;
    private List<ContactDetails> contactDetailsList;

    public TrieNode() {
        this.children = new ConcurrentHashMap<>();
        this.isEndOfContact = false;
        this.contactDetailsList = new ArrayList<>();
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEndOfContact() {
        return isEndOfContact;
    }

    public void setEndOfContact(boolean endOfContact) {
        isEndOfContact = endOfContact;
    }

    public List<ContactDetails> getContactDetailsList() {
        return contactDetailsList;
    }

    public void addContactDetails(ContactDetails contactDetails) {
        this.contactDetailsList.add(contactDetails);
    }
}

