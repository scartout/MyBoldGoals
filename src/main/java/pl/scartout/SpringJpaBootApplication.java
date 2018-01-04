package pl.scartout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.scartout.dao.RoleDao;
import pl.scartout.model.Role;

@SpringBootApplication
public class SpringJpaBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBootApplication.class, args);

        RoleDao roleDao = ctx.getBean(RoleDao.class);
        Role role1 = new Role("admin");
        Role role2 = new Role("user");
        roleDao.save(role1);
        roleDao.save(role2);
        
    }
}