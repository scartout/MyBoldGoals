package pl.scartout.repo;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import pl.scartout.model.Goal;
 
@Repository
public interface GoalRepo extends JpaRepository<Goal, Long> {
	List<Goal> findAllByUserId(long id);
}