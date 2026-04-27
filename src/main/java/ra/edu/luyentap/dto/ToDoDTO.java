package ra.edu.luyentap.dto;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ToDoDTO {
    @NotBlank(message = "Nội dung không được để trống!")
    private String content;

    @NotNull(message = "Vui lòng chọn ngày!")
    @FutureOrPresent(message = "Ngày phải từ hôm nay trở đi!")
    private LocalDate dueDate;

    private boolean status;
    @NotNull(message = "Không được để trống trạng thái")
    private String priority;
}
