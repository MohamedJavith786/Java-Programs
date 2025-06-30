import java.util.Scanner;

public class ATM {
    private static double balance = 1000.00; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the ATM!");

        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose between 1-4.");
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    public static void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
        } else {
            balance += amount;
            System.out.printf("$%.2f deposited successfully.%n", amount);
            checkBalance();
        }
    }

    public static void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction cancelled.");
        } else {
            balance -= amount;
            System.out.printf("$%.2f withdrawn successfully.%n", amount);
            checkBalance();
        }
    }
}
