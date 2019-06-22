package yuans.amnesia.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import yuans.amnesia.spring.entity.Role;
import yuans.amnesia.spring.entity.User;
import yuans.amnesia.spring.repository.RoleRepository;
import yuans.amnesia.spring.repository.UserRepository;

import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initUser(UserRepository userRepository,
                                      RoleRepository roleRepository) {
        return args -> {
            Role role0 = new Role();
            role0.setName("USER");
            roleRepository.save(role0);

            User user = new User();
            user.setName("user");
            user.setPassword("password");
            user.setRoles(Collections.singletonList(role0));
            userRepository.save(user);

//            System.out.println(userRepository
//                    .findAll()
//                    .stream()
//                    .map(User::getName)
//                    .collect(Collectors.toList()));
        };
    }
}
