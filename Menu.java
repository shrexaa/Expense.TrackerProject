package Tracker;

import java.util.Scanner;

public class Menu {
    private ExpenseManager manager;
    private Scanner sc;

    public Menu() {
        manager = new ExpenseManager();
        sc = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n--- Personal Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Summary");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> manager.viewExpenses();
                case 3 -> manager.viewSummary();
                case 4 -> System.out.println("Thank you for using the tracker.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    private void addExpense() {
        System.out.print("Enter category (e.g., Food, Travel): ");
        String category = sc.nextLine();
        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume newline
        System.out.print("Enter date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        manager.addExpense(category, amount, date);
    }
}



