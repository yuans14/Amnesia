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
import yuans.amnesia.spring.service.ModelService;

import java.util.List;

@RestController
public class ModelController {

    private final ModelService service;

    @Autowired
    public ModelController(ModelService service) {
        this.service = service;
    }

    @GetMapping("/v1/models/{id}")
    public Model findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping("/v1/models")
    public List<Model> findAll() {
        return service.findAll();
    }

    @GetMapping("/v1/models/page")
    public Page<Model> findAllWithPage(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return service.findAllWithPage(pageable);
    }

    @PostMapping("/v1/models")
    public Model save(@RequestBody Model model) {
        return service.save(model);
    }

    @PutMapping("/v1/models")
    public Model update(@RequestBody Model model) {
        return service.update(model);
    }

    @PatchMapping("/v1/models/{id}")
    public Model updateCode(@PathVariable("id") Long id,
                            @RequestParam("code") String code) {
        return service.updateCode(id, code);
    }

    @DeleteMapping("/v1/models/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/v1/models")
    public void deleteAll() {
        service.deleteAll();
    }
}
