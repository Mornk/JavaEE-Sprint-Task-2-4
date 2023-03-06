package db;

import models.Tasks;

import java.util.ArrayList;

public class DBManager {
     static ArrayList<Tasks> tasks = new ArrayList<>();
     static Long id = 5L;
     static {
         tasks.add(new Tasks(1L,"Создать Веб Приложение на Java EE","Создать Веб Приложение на Java EE","06-03-2023"));
         tasks.add(new Tasks(2L,"Убраться дома","Убраться дома","05-03-2023"));
         tasks.add(new Tasks(3L,"Выполнить все домашние задания","Выполнить все домашние задания","06-03-2023"));
         tasks.add(new Tasks(4L,"Найти людей на практику","Найти людей на практику","10-03-2023"));
     }
     public static void addTask(Tasks task){
         task.setId(id);
         tasks.add(task);
         id++;
    }
    public static Tasks getTask(Long id){
         for (Tasks task : tasks){
             if (task.getId().equals(id)){
                 return task;
             }
         }
         return null;
    }
    public static ArrayList<Tasks> getAllTasks(){
         return tasks;
    }
   public static void deleteTask(Long id){
         for (int i =0;i<tasks.size();i++){
             Tasks task = tasks.get(i);
             if (task.getId().equals(id)){
                 tasks.remove(i);
                 break;
             }
         }
        for (Tasks task : tasks) {
            if (task.getId() > id) {
                task.setId(task.getId() - 1);
            }
        }
    }
    public static void changeTaskName(Long id, String name) {
        Tasks task = getTask(id);
        if (task != null) {
            task.setName(name);
        }
    }
    public static void changeTaskDescription(Long id, String description) {
        Tasks task = getTask(id);
        if (task != null) {
            task.setDescription(description);
        }
    }
    public static void changeTaskStatus(Long id, String status) {
        Tasks task = getTask(id);
        if (task != null) {
            task.setStatus(status);
        }
    }
    public static void changeTaskDeadline(Long id, String date) {
        Tasks task = getTask(id);
        if (task != null) {
            task.setDeadlineDate(date);
        }
    }
}