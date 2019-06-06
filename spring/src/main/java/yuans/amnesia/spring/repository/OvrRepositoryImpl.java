package yuans.amnesia.spring.repository;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;

public class OvrRepositoryImpl<T> implements OvrRepository<T> {

    private final EntityManager em;

    public OvrRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void delete(T entity) {
        System.out.println("custom delete implementation");

        Assert.notNull(entity, "The entity must not be null!");
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
