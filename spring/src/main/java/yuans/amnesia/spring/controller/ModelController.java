package yuans.amnesia.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yuans.amnesia.spring.entity.Model;
import yuans.amnesia.spring.repository.ModelRepository;

import java.util.List;

@RestController
public class ModelController {

    private final ModelRepository repository;

    @Autowired
    public ModelController(ModelRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/v1/models")
    public Model save(@RequestBody Model model) {
        return repository.save(model);
    }

    @PutMapping("/v1/models")
    public Model update(@RequestBody Model model) {
        return repository.save(model);
    }

    @PatchMapping("/v1/models/{id}/{code}")
    public Model update(@PathVariable("id") Long id, @PathVariable("code") String code) {
        Model model = repository.findById(id).orElseGet(Model::new);
        model.setCode(code);
        return repository.save(model);
    }

    @DeleteMapping("/v1/models/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/v1/models")
    public List<Model> findAll() {
        return repository.findAll();
    }
}
