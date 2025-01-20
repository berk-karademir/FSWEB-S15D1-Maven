package org.example.mobile;

import java.util.*;

public class MobilePhone {


    private static final Set<String> existingPhoneNumbers = new HashSet<>();

    private String myNumber;
    private List<Contact> myContacts;


    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
        System.out.println("Your mobile phone is ready with the number " + myNumber );
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    //methods

    public boolean addNewContact(Contact contact) {
        if (contact == null || contact.getName() == null || contact.getPhoneNumber() == null) {
            System.out.println("Something gone wrong");
            return false;
        }
        // Telefon numarasının daha önce eklenip eklenmediğini kontrol et
        if (findContactByPhoneNumber(contact.getPhoneNumber()) >= 0) {
            System.out.println("Check the " + contact.getName() + "'s phone number ("+ contact.getPhoneNumber() +"), this number is already in your contact list!");
            return false;
        } else {
            System.out.println(contact.getName() + " has been added to your contact list successfully with the phone number " + contact.getPhoneNumber());
            return this.myContacts.add(contact);
        }

    }

    // Telefon numarasını kontrol etmek için yardımcı metod
    private int findContactByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            if (this.myContacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                return i;
            }
        }
        return -1; // Numara bulunamazsa -1 döndür
    }


    public boolean updateContact(Contact oldContact, Contact newContact) {
        int oldContactIndex = findContact(oldContact);
        if (oldContactIndex < 0) {
            return Boolean.FALSE;
        }
        this.myContacts.set(oldContactIndex, newContact);
        return Boolean.TRUE;
    }

    public boolean removeContact(Contact contact) {
        if (contact == null || findContact(contact) < 0) {
            return false;
        }
        return this.myContacts.remove(contact);
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equalsIgnoreCase(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {
        int index = findContact(contactName);
        if (index < 0) {
            System.out.println(contactName + " not found in contacts.");
            return null;
        }

        Contact foundContact = this.myContacts.get(index);
        System.out.println(contactName + "'s index is " + index +
                " and Phone number is " + foundContact.getPhoneNumber());
        return foundContact;
    }



    public void printContacts() {
        if (!myContacts.isEmpty()) {
            System.out.println("My contacts:");
            int index = 1;
            for (Contact contact : myContacts) {
                System.out.println(index++ + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
            }
        } else {
            System.out.println("You have not added any contacts yet.");
        }


    }



    @Override
    public String toString() {
        StringBuilder contactsString = new StringBuilder();
        for (Contact contact : myContacts) {
            contactsString.append(contact).append("\n");
        }

        return "My phone Number is: " + myNumber + "\n" +
                (contactsString.isEmpty() ?"You have not added any contacts yet." : "My contacts: " +  myContacts);

    }

    public static void br() {
        System.out.println("-----------------------------------------------------------------------");
    }

    public static void main(String[] args) {

        MobilePhone mobilePhone = new MobilePhone("0252 500 50 50");
        mobilePhone.printContacts();

        mobilePhone.addNewContact(new Contact("Ali", "555"));
        br();

        Contact contact1 = new Contact("John", "123");
        Contact contact2 = new Contact("John2", "123");
        Contact contact3 = new Contact("Jane", "67890");
        Contact contact4 = new Contact("Berk", "999 999");
        System.out.println();
        mobilePhone.addNewContact(contact1);
        mobilePhone.addNewContact(contact2);
        mobilePhone.addNewContact(contact3);
        System.out.println(contact4);
        mobilePhone.addNewContact(contact4);

        br();
        System.out.println(mobilePhone.queryContact("Ali"));
        System.out.println(mobilePhone.queryContact("Usman"));
        br();

        mobilePhone.printContacts();

    }

}
