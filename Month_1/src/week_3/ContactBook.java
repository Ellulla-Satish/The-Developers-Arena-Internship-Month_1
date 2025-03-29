package week_3;

import java.util.HashMap;
import java.util.Scanner;

class Contact
{
	String name;
    String phoneNumber;

    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}

public class ContactBook
{
	private HashMap<String, Contact> contacts = new HashMap<>();

    // Add Contact
    public void addContact(String name, String phoneNumber) {
        contacts.put(name.toLowerCase(), new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }

    // Delete Contact
    public void deleteContact(String name) {
        if (contacts.remove(name.toLowerCase()) != null) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Search Contact
    public void searchContact(String name) {
        Contact contact = contacts.get(name.toLowerCase());
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Display All Contacts
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook contactBook = new ContactBook();

        while (true) {
            System.out.println("\nContact Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    contactBook.addContact(name, phone);
                    break;
                case 2:
                    System.out.print("Enter Name to Delete: ");
                    contactBook.deleteContact(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter Name to Search: ");
                    contactBook.searchContact(scanner.nextLine());
                    break;
                case 4:
                    contactBook.displayContacts();
                    break;
                case 5:
                    System.out.println("Exiting Contact Book. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
