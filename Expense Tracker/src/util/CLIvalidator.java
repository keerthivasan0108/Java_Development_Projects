package util;

import java.time.LocalDate;

import controller.ExpenseController;
import main.Main;
import model.Expense;

public class CLIvalidator {
    public void check_command(String commandline){
        String s[] = commandline.split(" ");
        String command = s[0];
        int id = 0;
        ExpenseController controller = new ExpenseController();
        switch (command) {
            
            case "add":
                String d = s[1];
                String desc = s[2];
                String a = s[3];
                int amount = Integer.parseInt(s[4]);
                
                if(d.equals("--description") && a.equals("--amount")){
                    id=controller.generateId();
                    LocalDate today = LocalDate.now();
                    new ExpenseController().addExpense(id, today, desc, amount);
                    System.out.println("Expense added Successfully (ID : "+id+")");
                }
                
                break;
            case "list":
                System.out.println("ID\tDate\t\tDescription\tAmount");
                new ExpenseController().getAllExpenses();
                
                break;

            case "update":
                String i = s[1];
                Integer idd = Integer.parseInt(s[2]);
                String de = s[3];
                String descr = s[4];
                String aa = s[5];
                Integer amountt = Integer.parseInt(s[6]);
                LocalDate today = LocalDate.now();
                if(i.equals("--id")&& de.equals("--description")&& aa.equals("--amount")){
                    Expense e = new Expense(idd,today,descr,amountt);
                    new ExpenseController().updateExpense(idd, e);
                }
                
                break;
             
            case "delete":
                String s1 = s[1];
                Integer Id = Integer.parseInt(s[2]);
                if(s1.equals("--id")){
                    new ExpenseController().deleteExpense(Id);
                }
               System.out.println("Expense deleted successfully");
                break;
            
            case "summary":
                new ExpenseController().summary();
               
           
            default:
                break;
        }
    }
}   
