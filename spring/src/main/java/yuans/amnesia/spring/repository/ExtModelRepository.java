package yuans.amnesia.spring.repository;

import yuans.amnesia.spring.entity.Model;

import java.util.Optional;

public interface ExtModelRepository {

    boolean isSavedToday(Optional<Model> model);
}
