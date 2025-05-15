package Tracker;

import java.util.*;

public class ExpenseManager {
    private ArrayList<Expense> expenses;

    public ExpenseManager() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String category, double amount, String date) {
        Expense e = new Expense(category, amount, date);
        expenses.add(e);
        System.out.println("Expense added.");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to show.");
            return;
        }
        System.out.println("\nDate       | Category | Amount");
        System.out.println("-------------------------------");
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public void viewSummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to summarize.");
            return;
        }

        double total = 0;
        Map<String, Double> categoryMap = new HashMap<>();

        for (Expense e : expenses) {
            total += e.getAmount();
            categoryMap.put(e.getCategory(), categoryMap.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }

        System.out.println("\nTotal Expenses: ₹" + total);
        System.out.println("Category-wise Breakdown:");
        for (String cat : categoryMap.keySet()) {
            System.out.println(cat + ": ₹" + categoryMap.get(cat));
        }
    }
}
