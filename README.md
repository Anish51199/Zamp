# Zamp

**Tech Used**: Java

**Assumption**:
    <pre>Same name can have multiple entries.</pre>

**Approach**:
    <pre> Taken two tries one for name searching and other
 for phone number searching.</pre>
**Design**:
<pre>
Model classes:
    TrieNode: Class containing structure trie node
    ContactDetails: Class containing structure of Contacts.

AddressBookManager:
    Class containing initialization of both trie nodes
    (phoneTrieNode and nameTrieNode) and all the methods
    adding contacts and searching 

Main:
    Mock data execution.

</pre>