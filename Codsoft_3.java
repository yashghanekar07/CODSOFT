//  AtmInterface

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(){
        this.balance = 0;
    }

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                if (deposit(depositAmount)) {
                    System.out.println("Deposit successful.");
                } else {
                    System.out.println("Deposit failed. Amount must be positive.");
                }
                break;
            case 3:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
                }
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }
    }

    private void checkBalance() {
        double balance = account.checkBalance();
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    private boolean deposit(double amount) {
        return account.deposit(amount);
    }

    private boolean withdraw(double amount) {
        return account.withdraw(amount);
    }

    public void start() {
        while (true) {
            displayMenu();
            System.out.print("Select an option: ");
            int userChoice = scanner.nextInt();
            if (userChoice == 4) {
                break;
            }
            processChoice(userChoice);
        }
    }
}

public class Codsoft_3 {
    public static void main(String[] args) {
        // Create a bank account with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM instance connected to the user's bank account
        ATM atm = new ATM(userAccount);

        // Start the ATM
        atm.start();
    }
}
