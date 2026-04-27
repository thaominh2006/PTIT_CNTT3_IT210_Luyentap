package ra.edu.luyentap.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.luyentap.dto.ToDoDTO;
import ra.edu.luyentap.model.ToDo;
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
    @GetMapping("/todos/edit/{id}")
    public String editTodo(
            @PathVariable(name = "id") Long id,
            Model model
    ){
        for (ToDo t: todoService.getAllTodo()) {
            if (t.getId().equals(id)) {
                model.addAttribute("editTodo", t);
            }
        }
        return "updatetodo";
    }

    @PostMapping("/todos/update")
    public String updateTodo(
            @Valid
            @ModelAttribute(name ="editTodo") ToDoDTO todoDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ){
        if (result.hasErrors()) {
            return "updatetodo";
        }
        System.out.println(todoDTO.getId());
        todoService.updateTodo(todoDTO);
        redirectAttributes.addFlashAttribute("message","Thao tác thành công!");
        return "redirect:/todos";
    }

    @GetMapping("/todos/delete/{id}")
    public String deleteTodo(
            @PathVariable(name="id") Long id,
            RedirectAttributes redirectAttributes
    ){
        redirectAttributes.addFlashAttribute("message","Thao tác thành công!");
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }
}
