package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private String myNumber;
    private List<Contact> myContacts; {
    };


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
            return false;
        }
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        return this.myContacts.add(contact);

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
        System.out.println( contactName + " found at index " + index);
        return this.myContacts.get(index);
    }

    public void printContacts() {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "myNumber='" + myNumber + '\'' +
                ", myContacts=" + myContacts +
                '}';
    }

    public static void main(String[] args) {

        List<Contact> myContacts = new ArrayList<>();
        MobilePhone mobilePhone = new MobilePhone("11111111", myContacts);
        mobilePhone.addNewContact(new Contact("Ali", "12345678"));
        System.out.println(mobilePhone);


        Contact contact1 = new Contact("John", "12345");
        Contact contact2 = new Contact("John", "12345");
        Contact contact3 = new Contact("Jane", "67890");
        System.out.println(contact1.equals(contact2)); // true
        System.out.println(contact1.equals(contact3)); // false
        System.out.println(contact1.equals("Not a Contact")); // false


        System.out.println(mobilePhone.queryContact("Ali"));
        System.out.println(mobilePhone.queryContact("Usman"));

        mobilePhone.addNewContact(new Contact("Cabbaar","345"));

        mobilePhone.addNewContact(new Contact("Cabbaar","345"));
        System.out.println(mobilePhone.getMyContacts());

    }

}
