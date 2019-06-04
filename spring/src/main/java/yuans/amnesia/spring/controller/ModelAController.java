package yuans.amnesia.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yuans.amnesia.spring.entity.ModelA;
import yuans.amnesia.spring.repository.ModelARepository;

import java.util.List;

@RestController
public class ModelAController {

    private final ModelARepository repository;

    @Autowired
    public ModelAController(ModelARepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<ModelA> findAll(){
        return repository.findAll();
    }
}
