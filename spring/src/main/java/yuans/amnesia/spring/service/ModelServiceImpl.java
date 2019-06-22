package yuans.amnesia.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import yuans.amnesia.spring.entity.Model;
import yuans.amnesia.spring.repository.ModelRepository;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private ModelRepository repository;

    @Autowired
    public ModelServiceImpl(ModelRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable("models")
    public Model findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Cacheable(value = "models", key = "'all'")
    public List<Model> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Model> findAllWithPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Caching(put = @CachePut(value = "models", key = "#result.id"),
            evict = @CacheEvict(value = "models", key = "'all'"))
    public Model save(Model model) {
        Assert.isNull(model.getId(), "The given id must be null");
        return repository.save(model);
    }

    @Override
    @Caching(put = @CachePut(value = "models", key = "#result.id"),
            evict = @CacheEvict(value = "models", key = "'all'"))
    public Model update(Model model) {
        Assert.notNull(model.getId(), "The given id must not be null");
        return repository.save(model);
    }

    @Override
    @Caching(put = @CachePut(value = "models", key = "#result.id"),
            evict = @CacheEvict(value = "models", key = "'all'"))
    public Model updateCode(Long id, String code) {
        Model model = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The model must exist"));
        model.setCode(code);
        return repository.save(model);
    }

    @Override
    @Caching(evict = {@CacheEvict("models"),
            @CacheEvict(value = "models", key = "'all'")})
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @CacheEvict(value = "models", allEntries = true)
    public void deleteAll() {
        repository.deleteAll();
    }
}
