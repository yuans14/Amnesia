package yuans.amnesia.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import yuans.amnesia.spring.repository.CuzAllRepositoryImpl;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = CuzAllRepositoryImpl.class)
public class JpaConfiguration {
}
