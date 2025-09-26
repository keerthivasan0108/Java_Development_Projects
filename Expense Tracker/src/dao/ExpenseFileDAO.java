package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Expense;

public class ExpenseFileDAO implements Expensedao{

    private final File file;
    static List<Expense> expenses = new ArrayList<>();
    public ExpenseFileDAO(String filename){
        this.file = new File(filename);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private List<Expense> loadespenses(){
       try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                if(!line.trim().isEmpty()){
                    expenses.add(Expense.fromString(line));
                }
            }
       }
       catch (IOException e) {
        e.printStackTrace();
       }
       return expenses;
    }

    private void saveexpenses(List<Expense>expenses){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(Expense e:expenses){
                writer.write(e.toString());
                writer.newLine();
            }
        }catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void addExpense(Expense expense){
        expenses.add(expense);
        saveexpenses(expenses);
    }

    //update
    public void updateExpense(int id, Expense e){
        for(int i=0;i<expenses.size();i++){
            if(expenses.get(i).getId()==id){
                expenses.set(i, e);
                break;
            }
        }
        saveexpenses(expenses);
    }

    public void deleteExpense(int id){
        for(int i=0;i<expenses.size();i++){
            if(expenses.get(i).getId()==id){
                expenses.remove(expenses.get(i));
                break;
            }
        }
        saveexpenses(expenses);

    }
    public List<Expense>getAllExpenses(){
    
        return expenses;
    }
    public Expense getExpenseById(int id){
        for(int i=0;i<expenses.size();i++){
            if(expenses.get(i).getId()==id){
                return expenses.get(i);
            }
        }
        return null;
    }

    public int summary(){
        int total=0;
        for(int i=0;i<expenses.size();i++){
            total += expenses.get(i).getAmount();
        }
        return total;
    }
}
