package yuans.amnesia.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import yuans.amnesia.spring.entity.ModelA;
import yuans.amnesia.spring.repository.ModelARepository;

import java.util.List;

@RestController
public class ModelAController {

    private final ModelARepository modelARepository;

    @Autowired
    public ModelAController(ModelARepository modelARepository) {
        this.modelARepository = modelARepository;
    }

    @GetMapping("/{code}")
    public List<ModelA> findModelA(@PathVariable("code") String code){
        return modelARepository.findByCode(code);
    }
}
