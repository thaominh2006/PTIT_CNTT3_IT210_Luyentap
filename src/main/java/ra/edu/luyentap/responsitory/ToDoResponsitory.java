package ra.edu.luyentap.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.edu.luyentap.model.ToDo;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoResponsitory extends JpaRepository<ToDo,Long> {
}
