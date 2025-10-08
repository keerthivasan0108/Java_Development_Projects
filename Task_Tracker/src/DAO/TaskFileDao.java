package DAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Task;

public class TaskFileDao implements Taskdao{
    private static File file;
    public static List<Task>Tasks = new ArrayList<>();

    /**
     * @param filename
     */
    public TaskFileDao(String filename){
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

    private static List<Task> loadTasks(){
        Tasks.clear();   
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine())!=null){
                if(!line.trim().isEmpty()){
                    Tasks.add(Task.FromString(line));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return Tasks;
    }

    private static void saveTasks(List<Task>Tasks){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(Task e:Tasks){
                writer.write(e.toString());
                writer.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(Task task){
        Tasks.add(task);
        saveTasks(Tasks);
    }

    @Override
    public void update(int id, Task task){
        for (int i = 0; i < Tasks.size(); i++) {
            if (Tasks.get(i).getId() == id) {
                Tasks.set(i, task);            // use the list index
                saveTasks(Tasks);              // don’t forget to persist!
                break;
        }
    }
}

    @Override
    public void delete(int id){
        for (int i = 0; i < Tasks.size(); i++) {
            if (Tasks.get(i).getId() == id) {
                Tasks.remove(i);               // remove by list index
                saveTasks(Tasks);              // persist after removal
                break;
            }
        }
    }

    @Override
    public List<Task> allTasks(){
        loadTasks();
        return Tasks;
    }

    @Override
    public List<Task> listtodo(){
        List<Task> todo = new ArrayList<>();
        for(Task e:Tasks){
            if(e.getStatus().equals("todo")){
                todo.add(e);
            }
        }
        return todo;

    }

    @Override
    public List<Task> listdone(){
        List<Task> done = new ArrayList<>();
        for(Task e:Tasks){
            if(e.getStatus().equals("done")){
                done.add(e);
            }
        }
        return done;

    }

    @Override
    public List<Task> listinprogress(){
        List<Task> in_p = new ArrayList<>();
        for(Task e:Tasks){
            if(e.getStatus().equals("in-progress")){
                in_p.add(e);
            }
        }
        return in_p;

    }

    @Override
    public void mark_status(Integer id,String status){
        loadTasks();
        for(Task e:Tasks){
            if(e.getId()==id){
                e.setStatus(status);
            }
        }
        saveTasks(Tasks);
    }

}
