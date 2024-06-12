package FinalExam;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public AddressBook() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Company: ");
        String company = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        Contact contact = new Contact(name, company, email, phoneNumber);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void showContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}
