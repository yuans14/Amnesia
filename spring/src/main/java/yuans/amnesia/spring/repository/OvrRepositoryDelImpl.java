package yuans.amnesia.spring.repository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;

public class OvrRepositoryDelImpl<T> implements OvrRepositoryDel<T> {

    private final EntityManager em;

    public OvrRepositoryDelImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void delete(T entity) {
        //customized delete implementation

        Assert.notNull(entity, "The entity must not be null!");
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
