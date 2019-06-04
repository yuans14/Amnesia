package yuans.amnesia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yuans.amnesia.spring.entity.ModelA;

public interface ModelARepository extends JpaRepository<ModelA, Long> {

}
