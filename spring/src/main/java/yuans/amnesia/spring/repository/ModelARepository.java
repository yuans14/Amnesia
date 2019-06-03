package yuans.amnesia.spring.repository;

import org.springframework.data.repository.CrudRepository;
import yuans.amnesia.spring.entity.ModelA;

import java.util.List;

public interface ModelARepository extends CrudRepository<ModelA, Long> {

    List<ModelA> findByCode(String code);
}
