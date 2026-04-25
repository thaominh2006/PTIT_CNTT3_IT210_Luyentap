package ra.edu.luyentap.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.luyentap.dto.ToDoDTO;
import ra.edu.luyentap.model.ToDo;
import ra.edu.luyentap.responsitory.ToDoResponsitory;
import ra.edu.luyentap.service.ToDoService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
    private final ToDoResponsitory todoRepository;

    @Override
    public List<ToDo> getAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public void addTodo(ToDoDTO newTodo) {
        ToDo todo = new ToDo();
        todo.setContent(newTodo.getContent());
        todo.setDueDate(newTodo.getDueDate());
        todo.setPriority(newTodo.getPriority());
        todo.setStatus(false);

        todoRepository.save(todo);
    }
}
