package yuans.amnesia.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yuans.amnesia.spring.entity.Model;
import yuans.amnesia.spring.repository.ModelRepository;

import java.util.Date;

@RestController
public class ModelController {

    private final ModelRepository repository;

    @Autowired
    public ModelController(ModelRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/v1/models")
    public Page<Model> find(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PostMapping("/v1/models")
    public Model save(@RequestBody Model model) {
        model.setId(null);
        return repository.save(model);
    }

    @PutMapping("/v1/models/{id}")
    public Model update(@PathVariable("id") Long id,
                        @RequestBody Model model) {
        model.setId(id);
        return repository.save(model);
    }

    @PatchMapping("/v1/models/{id}")
    public Model update(@PathVariable("id") Long id,
                        @RequestParam("code") String code) {
        Model model = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The model must exist"));
        model.setCode(code);
        model.setOperateTime(new Date());
        return repository.save(model);
    }

    @DeleteMapping("/v1/models/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
