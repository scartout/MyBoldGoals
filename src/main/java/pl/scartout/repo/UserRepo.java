package pl.scartout.repo;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import pl.scartout.model.User;
 
@Repository
@Transactional
public class UserRepo extends GenericRepo<User, Long> {
}