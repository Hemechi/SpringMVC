package co.cstad.todolist.repository;

import co.cstad.todolist.model.ToDoList;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoListDataSource {
    List<ToDoList> list = new ArrayList<>();
    public TodoListDataSource(){
        list.add(new ToDoList(12,"assignment","Assignment due tomorrow",false, LocalDate.now()));
        list.add(new ToDoList(13,"homework","homework due today",true, LocalDate.now()));
    }
    public List<ToDoList> todoListDataSource(){
        return list;
    }
}
