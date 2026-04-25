package ra.edu.luyentap.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.luyentap.dto.ToDoDTO;
import ra.edu.luyentap.service.ToDoService;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService todoService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("todos", todoService.getAllTodo());
        return "todo";
    }

    @GetMapping("/add")
    public String viewAdd(Model model){
        model.addAttribute("addtodo", new ToDoDTO());
        return "addTodo";
    }


    @PostMapping("/add")
    public String addTodo(
            @Valid
            @ModelAttribute(name = "addtodo") ToDoDTO newTodo,
            BindingResult result

    ) {
        if (result.hasErrors()) {
            return "addTodo";
        }
        todoService.addTodo(newTodo);
        return "redirect:/";
    }
}
