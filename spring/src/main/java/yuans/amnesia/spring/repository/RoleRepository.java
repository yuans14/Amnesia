package yuans.amnesia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yuans.amnesia.spring.entity.Role;

public interface RoleRepository extends
        JpaRepository<Role, Long> {
}
