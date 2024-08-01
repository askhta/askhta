package FinalExam;

import java.util.Scanner;

public class MainMenu {
     private static AddressBook addressBook = new AddressBook();

     public static void main(String[] args) {
          createMenu();
     }

     public static void createMenu() {
          Scanner sc = new Scanner(System.in);
          int choice;

          do {
               System.out.println("1. Add new contact");
               System.out.println("2. Find contact by name");
               System.out.println("3. Display all contacts");
               System.out.println("4. Exit");
               System.out.println("Please enter your choice:");
               choice = sc.nextInt();
               sc.nextLine();  // Consume newline

               switch (choice) {
                    case 1:
                         addressBook.addContact();
                         break;
                    case 2:
                         System.out.println("The function has not been implemented yet");
                         break;
                    case 3:
                         addressBook.showContacts();
                         break;
                    case 4:
                         System.out.println("Thanks for using this program");
                         break;
                    default:
                         System.out.println("Please enter a valid choice");
                         break;
               }
          } while (choice != 4);

          sc.close();
     }
}
