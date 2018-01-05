package pl.scartout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.scartout.model.Role;
import pl.scartout.repo.RoleRepo;

@SpringBootApplication
public class SpringJpaBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBootApplication.class, args);

        RoleRepo roleRepo = ctx.getBean(RoleRepo.class);
        Role role1 = new Role("admin");
        Role role2 = new Role("user");
        roleRepo.save(role1);
        roleRepo.save(role2);
        
    }
}