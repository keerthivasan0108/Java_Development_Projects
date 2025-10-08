package DAO;

import java.util.List;

import Model.Task;

public interface Taskdao {
    void add(Task task);
    void update(int id,Task task);
    void delete(int id);
    List<Task>allTasks();
    List<Task>listtodo();
    List<Task>listdone();
    List<Task>listinprogress();
    void mark_status(Integer id,String status);
    
}  
    

