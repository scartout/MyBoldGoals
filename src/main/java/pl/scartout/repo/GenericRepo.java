package pl.scartout.repo;
 
import java.lang.reflect.ParameterizedType;
 
import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
 
@Transactional
public abstract class GenericRepo<T, K> {
 
    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> type;
     
    @SuppressWarnings("unchecked")
    GenericRepo() {
        type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
 
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
    public T get(K key) {
        T find = entityManager.find(type, key);
        return find;
    }
    
    public void remove(T entity) {
        T managedEntity = entityManager.merge(entity);
        entityManager.remove(managedEntity);
    }
}