package ra.edu.luyentap.service;

import ra.edu.luyentap.dto.ToDoDTO;
import ra.edu.luyentap.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllTodo();

    void addTodo(ToDoDTO newTodo);
}
