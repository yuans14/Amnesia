package yuans.amnesia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yuans.amnesia.spring.entity.User;

public interface UserRepository extends
        JpaRepository<User, Long> {

    User findByName(String name);
}
