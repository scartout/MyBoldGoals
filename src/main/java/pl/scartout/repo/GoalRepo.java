package pl.scartout.repo;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import pl.scartout.model.Goal;
 
@Repository
@Transactional
public class GoalRepo extends GenericRepo<Goal, Long> {
}