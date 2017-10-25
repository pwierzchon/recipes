package pl.destino.recipes.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.destino.recipes.domain.Recipe;

/**
 *
 * @author Destino
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    
}
