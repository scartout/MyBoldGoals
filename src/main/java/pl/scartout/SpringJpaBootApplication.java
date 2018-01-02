package pl.scartout;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.scartout.dao.GoalDao;
import pl.scartout.dao.PositionDao;
import pl.scartout.dao.RoleDao;
import pl.scartout.dao.UserDao;
import pl.scartout.model.Goal;
import pl.scartout.model.Position;
import pl.scartout.model.Role;
import pl.scartout.model.User;

@SpringBootApplication
public class SpringJpaBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBootApplication.class, args);
        
        /*Role role = new Role("admin");
        RoleDao roleDao = ctx.getBean(RoleDao.class);
        roleDao.save(role);
        System.out.println(role);
         
        User user = new User("konduktor93", "morsmordre", "konduktor93@gmail.com");
        user.setRole(role);
        UserDao userDao = ctx.getBean(UserDao.class);
        userDao.save(user);
        System.out.println(user);
		
        Goal goal = new Goal(new Date(), new Date());
        goal.setUser(user);
		GoalDao goalDao = ctx.getBean(GoalDao.class);
		goalDao.save(goal);
		System.out.println(goal);
        
		Position position = new Position("Zaimplementować bazę danych");
		Position position2 = new Position("Utworzyć home kontroler");
		position.setGoal(goal);
		position2.setGoal(goal);

		PositionDao positionDao = ctx.getBean(PositionDao.class);
		positionDao.save(position);
		positionDao.save(position2);
		System.out.println(position);
		
		ctx.close();*/
    }
}