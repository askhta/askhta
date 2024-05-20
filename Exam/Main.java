package Exam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new AccountBank object
        AccountBank account = new AccountBank();

        // Enter account information
        System.out.println("Enter Account Number:");
        String accountNumber = scanner.nextLine();
        account.setAccountNumber(accountNumber);

        System.out.println("Enter Account Holder Name:");
        String accountHolderName = scanner.nextLine();
        account.setAccountHolderName(accountHolderName);

        System.out.println("Enter Initial Balance:");
        double initialBalance = scanner.nextDouble();
        account.setBalance(initialBalance);

        // Display account information
        System.out.println("Initial Account Information:");
        account.displayAccountInfo();

        // Perform transactions
        System.out.println("\nEnter transactions:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter deposit amount:");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 2:
                System.out.println("Enter withdrawal amount:");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 3:
                System.out.println("Enter destination account number:");
                String destinationAccountNumber = scanner.next();
                AccountBank destinationAccount = new AccountBank();
                destinationAccount.setAccountNumber(destinationAccountNumber);

                System.out.println("Enter transfer amount:");
                double transferAmount = scanner.nextDouble();
                account.transfer(destinationAccount, transferAmount);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        // Display updated account information
        System.out.println("\nUpdated Account Information:");
        account.displayAccountInfo();

        scanner.close();
    }
}