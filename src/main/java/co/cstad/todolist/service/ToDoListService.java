package co.cstad.todolist.service;

import co.cstad.todolist.model.ToDoList;

import java.util.List;

public interface ToDoListService {
    List<ToDoList> displayList();
    ToDoList getById(Integer id);
    void createList(ToDoList newList);
    void updateList(ToDoList updatedList);
    void deleteList(Integer id);
    List<ToDoList> searchList(String task, Boolean isDone);
}
