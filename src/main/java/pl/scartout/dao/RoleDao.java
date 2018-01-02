package pl.scartout.dao;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import pl.scartout.model.Role;
 
@Repository
@Transactional
public class RoleDao extends GenericDao<Role, Long> {
}