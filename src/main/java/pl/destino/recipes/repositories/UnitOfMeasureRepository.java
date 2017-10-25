package pl.destino.recipes.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import pl.destino.recipes.domain.UnitOfMeasure;

/**
 *
 * @author Destino
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
        Optional<UnitOfMeasure> findByDescription(String description);

}
