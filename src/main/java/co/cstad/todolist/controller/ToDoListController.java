package co.cstad.todolist.controller;

import co.cstad.todolist.model.ToDoList;
import co.cstad.todolist.service.ToDoListServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToDoListController {
   private final ToDoListServiceImpl service;

    public ToDoListController(ToDoListServiceImpl service) {
        this.service = service;
    }
    @GetMapping("/todo")
    public String index(Model model){
        model.addAttribute("todolist",service.displayList());
        return "index";
    }
    @GetMapping("/todo/{id}")
    public String getOneToDoList(@PathVariable("id") Integer id, Model model){
        model.addAttribute("todo",service.getById(id));
        return "index";
    }
    @GetMapping("/todo/new")
    public String showAddForm(Model model) {
        model.addAttribute("newList", new ToDoList());
        return "add";
    }

    @PostMapping("/todo/new")
    public String createNewToDoList(ToDoList newList, Model model) {
        service.createList(newList);
        model.addAttribute("message", "New todo-list added successfully!");
        return "redirect:/todo";
    }
    @GetMapping("/todo/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){
        ToDoList existingList = service.getById(id);
        model.addAttribute("editList", existingList);
        return "edit";
    }

    @PostMapping("/todo/update/{id}")
    public String updateList(@PathVariable("id") Integer id, @ModelAttribute("editList") ToDoList updatedList){
        updatedList.setId(id); // Ensure the ID remains the same
        service.updateList(updatedList);
        return "redirect:/todo";
    }
    @GetMapping("/todo/delete/{id}")
    public String deleteList(@PathVariable("id") Integer id) {
        service.deleteList(id);
        return "redirect:/todo";
    }
    @GetMapping("/todo/search")
    public String searchList(@RequestParam(required = false) String task,
                             @RequestParam(required = false) Boolean isDone,
                             Model model) {
        List<ToDoList> searchedList = service.searchList(task, isDone);
        model.addAttribute("todolist", searchedList);
        return "redirect:/todo";
    }
}
