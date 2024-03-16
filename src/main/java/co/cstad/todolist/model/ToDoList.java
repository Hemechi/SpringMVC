package co.cstad.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ToDoList {
    private Integer id;
    private String task;
    private String description;
    private Boolean isDone;
    private LocalDate createdAt;
}
