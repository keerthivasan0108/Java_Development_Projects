package Main;

import java.time.LocalDate;
import java.util.*;

import Controller.TaskController;



public class main {

    static TaskController taskController = new TaskController();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while(true){
            System.out.print("> "); // prompt
            String s = sc.nextLine();

            if (s.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            cli(s);

        }
        
        sc.close();

    }

    public static void cli(String s){
        String arr[] = s.split(" ");

        switch (arr[0]) {
            case "add":
                String de = arr[1];
                String status = arr[2];
                taskController.add(taskController.idgenerator(),de,status,LocalDate.now(),null);
                break;

            case "update":
                Integer id = Integer.parseInt(arr[1]);
                String desc = arr[2];
                String sta = arr[3];
                taskController.update(id,desc,sta,LocalDate.now());
                break;

            case "delete":
                Integer idd = Integer.parseInt(arr[1]);
                taskController.delete(idd);
                break;

            case "listall":
                taskController.allTasks();
                break;
            
            case "list-todo":
                taskController.listtodo();
                break;
            
            case "list-in-progress":
                taskController.listinprogress();
                break;

            case "list-done":
                taskController.listdone();
                break;
            
            case "mark":
                Integer i = Integer.parseInt(arr[1]);
                String st = arr[2];
                taskController.mark_status(i, st);
                break;

            default :
                break;

        }
    }

}
