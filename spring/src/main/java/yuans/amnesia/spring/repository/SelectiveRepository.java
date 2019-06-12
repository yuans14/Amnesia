package yuans.amnesia.spring.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface SelectiveRepository<T, ID extends Serializable> extends Repository<T, ID> {

    // copy the methods you want to expose from other Repository interface spring provided into there
}
