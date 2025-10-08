package Controller;

import java.time.LocalDate;
import java.util.ArrayList;

import DAO.TaskFileDao;
import Model.Task;

public class TaskController {
    private TaskFileDao taskFileDao;

    public ArrayList<Task> arr;

    public TaskController(){
        taskFileDao = new TaskFileDao("tasks.txt");
    }

    public void add(int id,String desc,String status,LocalDate createdAt,LocalDate updatedAt){
        Task task = new Task(id,desc,status,createdAt,updatedAt);
        taskFileDao.add(task);
    }

    public void update(int id,String desc,String status,LocalDate updatedAt){
        arr = (ArrayList<Task>) taskFileDao.allTasks();
        LocalDate createdAt = null;
        for(Task task:arr){
            if(id==task.getId()){
                createdAt = task.getCreatedAt();
                break;
            }
        }
        
        Task task = new Task(id,desc,status,createdAt,updatedAt);
        taskFileDao.update(id,task);
    }

    public void delete(int id){
        taskFileDao.delete(id);
    }

    public void allTasks(){
        arr = (ArrayList<Task>) taskFileDao.allTasks();
        for(Task i: arr){
            System.out.println(i.toString());
        }
    }

    public int idgenerator(){
        if (arr == null) {                       // if null, get from DAO
            arr = (ArrayList<Task>) taskFileDao.allTasks();
        }
    
        int maxid = 0;
        for(Task task : arr){
            if(task.getId() > maxid){
                maxid = task.getId();
            }
        }
        return maxid + 1;
    }

    public void listtodo(){
        arr = (ArrayList<Task>) taskFileDao.listtodo();
        for(Task i: arr){
            System.out.println(i.toString());
        }
    }

    public void listdone(){
        arr = (ArrayList<Task>) taskFileDao.listdone();
        for(Task i: arr){
            System.out.println(i.toString());
        }
    }

    public void listinprogress(){
        arr = (ArrayList<Task>) taskFileDao.listinprogress();
        for(Task i: arr){
            System.out.println(i.toString());
        }
    }

    public void mark_status(Integer id,String status){
        taskFileDao.mark_status(id,status);
    }

}   
