package Exam;

import java.util.Scanner;

public class AccountBank {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor with default values
    public AccountBank() {
        this.accountNumber = "";
        this.accountHolderName = "";
        this.balance = 0.0;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public String getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setAccountHolderName(String accountHolderNamer) {
        this.accountNumber = accountHolderName;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        this.balance += amount;
        System.out.println("Transfer successful");
    }

    public void withdraw(double amount) {
        if (amount <= 0){
            System.out.println("Invalid amount.");
            return;
        }
        if(amount > this.balance){
            System.out.println("Not enough money.");
            return;
        }
        this.balance -= amount;
    }

    public void transfer(AccountBank destinationAccount, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. ");
            return;
        }
        if(amount > this.balance){
            System.out.println("Not enough money.");
            return;
        }
        int destinationAccountIndex = -1;
        for (int i = 0; i < Main.accountBanks.size(); i++){
            AccountBank accountBank = Main.accountBanks.get(i);
            if (accountBank.getAccountNumber().equals(accountNumber)){
                destinationAccountIndex = i;
            }
        }
        if(destinationAccountIndex == -1){
            System.err.println("Account not found.");
            return;
        }
        this.balance -= amount;
        AccountBank destinationAccount = Main.accountBanks.get(destinationAccountIndex);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        System.out.println("Transfer successful");
    }
}

