package co.cstad.todolist.controller;

import co.cstad.todolist.service.ToDoListServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
