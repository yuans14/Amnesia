package yuans.amnesia.spring.repository;

import yuans.amnesia.spring.entity.Model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

public class ExtModelRepositoryImpl implements ExtModelRepository {

    @Override
    public boolean isSavedToday(Optional<Model> model) {
        return model.map(Model::getOperateTime)
                .map(time -> time.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate())
                .map(time -> LocalDate.now().equals(time))
                .orElse(false);
    }
}
