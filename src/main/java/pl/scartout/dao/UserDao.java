package pl.scartout.dao;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import pl.scartout.model.User;
 
@Repository
@Transactional
public class UserDao extends GenericDao<User, Long> {
}