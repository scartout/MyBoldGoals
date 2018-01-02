package pl.scartout.dao;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import pl.scartout.model.Position;
 
@Repository
@Transactional
public class PositionDao extends GenericDao<Position, Long> {
}