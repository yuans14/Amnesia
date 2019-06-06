package yuans.amnesia.spring.repository;

import yuans.amnesia.spring.entity.Model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

public class ExtModelRepositoryImpl implements ExtModelRepository {

    @Override
    public boolean isSaveToday(Optional<Model> model) {
        return model.map(Model::getSaveTime)
                .map(time -> time.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate())
                .map(time -> LocalDate.now().equals(time))
                .orElse(false);
    }
}
