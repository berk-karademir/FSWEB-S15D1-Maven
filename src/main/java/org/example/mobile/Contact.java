package org.example.mobile;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contact {

    private static final Set<String> existingPhoneNumbers = new HashSet<>();

    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        if (existingPhoneNumbers.contains(phoneNumber)) {
            System.out.println("The phone number " + phoneNumber + " is already in use!" + "Check number or existing your existing contacts.");
        }
//          aynı numara varsa konsola istediğin hatayı bas.
//        if (existingPhoneNumbers.contains(phoneNumber)) {
//            throw new IllegalArgumentException("The phone number " + phoneNumber + " is already in use!");
//        }
            else {
            this.name = name;
            this.phoneNumber = phoneNumber;
            existingPhoneNumbers.add(phoneNumber);

            System.out.println("New contact " + this.name + " has been created successfully, with phone number " + this.phoneNumber);
        }



    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Contact contact)) {
            return false;
        }
        return Objects.equals(name, contact.name) && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    @Override
    public String toString() {
        return "\n" +
                "Contact's Name: " + name + "\n" +
                "Phone Number: " + phoneNumber + "\n";
    }

    // Statik listeyi temizlemek için bir yardımcı metot (isteğe bağlı)
    public static void clearExistingPhoneNumbers() {
        existingPhoneNumbers.clear();
    }
}
