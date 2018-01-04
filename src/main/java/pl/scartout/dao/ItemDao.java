package pl.scartout.dao;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import pl.scartout.model.Item;
 
@Repository
@Transactional
public class ItemDao extends GenericDao<Item, Long> {
}