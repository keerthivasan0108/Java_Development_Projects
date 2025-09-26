package dao;

import java.util.List;

import model.Expense;

public interface Expensedao {
     void addExpense(Expense e);
     void updateExpense(int id, Expense e);
     void deleteExpense(int id);
     List<Expense>getAllExpenses();
     int summary();
     Expense getExpenseById(int id);
    
} 
