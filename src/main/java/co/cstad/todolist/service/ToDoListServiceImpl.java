package co.cstad.todolist.service;

import co.cstad.todolist.model.ToDoList;
import co.cstad.todolist.repository.TodoListDataSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListServiceImpl implements ToDoListService {
    private final TodoListDataSource dataSource;

    public ToDoListServiceImpl(TodoListDataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public List<ToDoList> displayList() {
        return dataSource.todoListDataSource();
    }

    @Override
    public void createList() {

    }

    @Override
    public void updateList() {

    }

    @Override
    public void deleteList() {

    }

    @Override
    public void searchList() {

    }
}
