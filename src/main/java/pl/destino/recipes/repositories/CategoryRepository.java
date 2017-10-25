package pl.destino.recipes.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import pl.destino.recipes.domain.Category;

/**
 *
 * @author Destino
 */
public interface CategoryRepository extends CrudRepository<Category, Long>{

    Optional<Category> findByDescription(String description);
}
