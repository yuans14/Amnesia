package yuans.amnesia.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import yuans.amnesia.spring.entity.Model;

import java.util.List;

public interface ModelService {

    Model findById(Long id);

    List<Model> findAll();

    Page<Model> findAllWithPage(Pageable pageable);

    Model save(Model model);

    Model update(Model model);

    Model updateCode(Long id, String code);

    void deleteById(Long id);

    void deleteAll();
}
