package yuans.amnesia.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import yuans.amnesia.spring.repository.CuzAllRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CuzAllRepositoryImpl.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
