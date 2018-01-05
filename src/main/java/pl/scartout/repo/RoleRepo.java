package pl.scartout.repo;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import pl.scartout.model.Role;
 
@Repository
@Transactional
public class RoleRepo extends GenericRepo<Role, Long> {
}