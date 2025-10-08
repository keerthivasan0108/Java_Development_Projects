package Model;

import java.time.LocalDate;

public class Task{
    private int id;
    private String description;
    private String status;
    private LocalDate createdAt;
    private LocalDate updatedAt;


    public Task(int id,String description,String status,LocalDate createdAt,LocalDate updatedAt){
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String toString(){
        return id+"\t"+description+"\t"+status+"\t"+createdAt+"\t"+updatedAt;
    }
    

    public Task(){
        
    }

    public static Task FromString(String line){
        String arr[] = line.split("\\s+");
        int id = Integer.parseInt(arr[0]);
        String desc = arr[1];
        String status = arr[2];
        LocalDate created = LocalDate.parse(arr[3]);
        LocalDate updated = null;
        if (!arr[4].equals("null")) {        // only parse if not "null"
            updated = LocalDate.parse(arr[4]);
        }
        return new Task(id,desc,status,created,updated);
    }

}