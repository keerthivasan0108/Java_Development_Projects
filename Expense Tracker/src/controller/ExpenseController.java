package controller;

import java.time.LocalDate;
import java.util.List;

import dao.ExpenseFileDAO;


public class ExpenseController {
    private ExpenseFileDAO expenseFileDAO;

    
    public void addExpense(int id,LocalDate date,String desc,int amount){
        Expense expense =  new Expense(id,date,desc,amount);
        expenseFileDAO.addExpense(expense);
        
    }

    public ExpenseController() {
        this.expenseFileDAO = new ExpenseFileDAO("expenses.txt");
    }
    

    public void updateExpense(int id,Expense e){
        expenseFileDAO.updateExpense(id, e);
    }

    public void deleteExpense(int id){
        expenseFileDAO.deleteExpense(id);
    }
    
    public void getAllExpenses(){
        for(Expense e: expenseFileDAO.getAllExpenses()){
            System.out.println(e.toString()); 
        }
    }

    public void getExpenseById(int id){
        Expense e =  expenseFileDAO.getExpenseById(id);
        System.out.println(e.toString());
    }

    public void summary(){
        int total = expenseFileDAO.summary();
        System.out.println("Total expenses: $"+total);
    }
    
    public int generateId() {
        int maxId = 0;
        for (Expense e : expenseFileDAO.getAllExpenses()) {
            if (e.getId() > maxId) {
                maxId = e.getId();
            }
        }
        return maxId + 1;
    }
    
}
