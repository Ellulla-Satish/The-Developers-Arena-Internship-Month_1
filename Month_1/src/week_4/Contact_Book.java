package week_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

class Contacts 
{
    String name;
    String phoneNumber;

    Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}


public class Contact_Book {
	private HashMap<String, Contacts> contacts = new HashMap<>();
    private static final String FILE_PATH = "contacts.txt";

    // Add Contact
    public void addContact(String name, String phoneNumber) {
        contacts.put(name.toLowerCase(), new Contacts(name, phoneNumber));
        System.out.println("Contact added successfully.");
        saveContactsToFile();
    }

    // Delete Contact
    public void deleteContact(String name) {
        if (contacts.remove(name.toLowerCase()) != null) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
        saveContactsToFile();
    }

    // Search Contact
    public void searchContact(String name) {
        Contacts contact = contacts.get(name.toLowerCase());
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
            for (Contacts contact : contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    // Save contacts to file
    public void saveContactsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Contacts contact : contacts.values()) {
                writer.write(contact.name + "," + contact.phoneNumber);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    // Load contacts from file
    public void loadContactsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 2) {
                    contacts.put(details[0].toLowerCase(), new Contacts(details[0], details[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contact_Book contactBook = new Contact_Book();
        contactBook.loadContactsFromFile();

        while (true) {
            System.out.println("\nContact Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Divide Two Numbers (Exception Demo)");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
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
                        System.out.print("Enter numerator: ");
                        int num = scanner.nextInt();
                        System.out.print("Enter denominator: ");
                        int denom = scanner.nextInt();
                        try {
                            System.out.println("Result: " + (num / denom));
                        } catch (ArithmeticException e) {
                            System.out.println("Error: Division by zero is not allowed.");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting Contact Book. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
