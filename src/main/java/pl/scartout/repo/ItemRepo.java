package pl.scartout.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.scartout.model.Item;
 
@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
	List<Item> findAllByGoalId(long id);
}