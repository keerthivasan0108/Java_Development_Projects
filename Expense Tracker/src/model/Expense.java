package model;
import java.time.LocalDate;

public class Expense{
    private int Id;
    private LocalDate Date;
    private String Description;
    private int Amount;
    private String category;
    

    public int getId() {
        return Id;
    }


    public void setId(int id) {
        Id = id;
    }


    public LocalDate getDate() {
        return Date;
    }


    public void setDate(LocalDate date) {
        Date = date;
    }


    public String getDescription() {
        return Description;
    }


    public void setDescription(String description) {
        Description = description;
    }


    public int getAmount() {
        return Amount;
    }


    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public Expense(int Id,LocalDate Date,String Description,int Amount){
        this.Id = Id;
        this.Date = Date;
        this.Description = Description;
        this.Amount = Amount;
        
    }


    public String toString(){
        return Id+" , "+Date+" , "+Description+" , "+Amount;
    }

    public static Expense fromString(String line){
        String arr[] = line.split(",");
        int id = Integer.parseInt(arr[0]);
        LocalDate date = LocalDate.parse(arr[1]);
        String description  = arr[2];
        Integer amount = Integer.parseInt(arr[3]);
        return new Expense(id,date,description,amount);
    }
    

}