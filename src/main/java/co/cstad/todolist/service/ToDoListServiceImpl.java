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
    public ToDoList getById(Integer id) {
        return dataSource.getById(id);
    }

    @Override
    public void createList(ToDoList newList) {
        dataSource.createList(newList);
    }

    @Override
    public void updateList(ToDoList updatedList) {
        dataSource.updateList(updatedList);
    }

    @Override
    public void deleteList(Integer id) {
        dataSource.deleteList(id);
    }

    @Override
    public List<ToDoList> searchList(String task, Boolean isDone) {
        return dataSource.searchList(task, isDone);
    }
}
