package pl.scartout.dao;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import pl.scartout.model.Goal;
 
@Repository
@Transactional
public class GoalDao extends GenericDao<Goal, Long> {
}