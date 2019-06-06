package yuans.amnesia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yuans.amnesia.spring.entity.Model;

public interface ModelRepository extends
        JpaRepository<Model, Long>, ExtModelRepository, OvrRepository<Model> {

}
