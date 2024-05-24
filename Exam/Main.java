package Exam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<AccountBank> accountBanks = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner - new Scanner(System.in);
        System.out.println("Welcome to EBank! ");
        System.out.println("Please enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Please enter your account holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.println("Please enter your account balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        AccountBank accountBank = new AccountBank();
        accountBank.setAccountNumber(accountNumber);
        accountBank.setAccountHolderName(accountHolderName);
        System.out.println("Your account balance: ");
        System.out.println("Your deposit method");
        double depositAmount = 2000;
        System.out.println("Deposit amount: " + depositAmount);
        accountBank.deposit(depositAmount);
        System.out.println("Your account balance after deposit: " + accountBank.getBalance());


    }
}

