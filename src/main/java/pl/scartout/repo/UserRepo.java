package pl.scartout.repo;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import pl.scartout.model.User;
 
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
	
	User findById(Long id);
}