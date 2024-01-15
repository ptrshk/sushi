package coursework.sushi.repository;

import coursework.sushi.entity.SushiEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SushiRepo extends CrudRepository<SushiEntity, Long> {
    List<SushiEntity> findByNameContaining(String sushiName);
    SushiEntity findByName(String sushiName);
}
