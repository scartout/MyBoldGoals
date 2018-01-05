package pl.scartout.repo;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import pl.scartout.model.Item;
 
@Repository
@Transactional
public class ItemRepo extends GenericRepo<Item, Long> {
	
}