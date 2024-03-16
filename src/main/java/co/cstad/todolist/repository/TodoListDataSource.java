package co.cstad.todolist.repository;

import co.cstad.todolist.model.ToDoList;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public ToDoList getById(Integer id) {
        return list.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public void createList(ToDoList newList) {
        list.add(newList);
    }
    public void updateList(ToDoList updatedList) {
        list.removeIf(todo -> todo.getId().equals(updatedList.getId()));
        list.add(updatedList);
    }
    public void deleteList(Integer id) {
        list.removeIf(todo -> todo.getId().equals(id));
    }
    public List<ToDoList> searchList(String task, Boolean isDone) {
        List<ToDoList> searchedList = new ArrayList<>();

        for (ToDoList todo : list) {
            if ((task == null || todo.getTask().contains(task))
                    && (isDone == null || todo.getIsDone().equals(isDone))) {
                searchedList.add(todo);
            }
        }
        return searchedList;
    }
}
