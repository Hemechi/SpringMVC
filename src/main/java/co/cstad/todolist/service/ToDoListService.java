package co.cstad.todolist.service;

import co.cstad.todolist.model.ToDoList;

import java.util.List;

public interface ToDoListService {
    List<ToDoList> displayList();
    void createList();
    void updateList();
    void deleteList();
    void searchList();
}
