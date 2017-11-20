/*
 */
package pl.destino.recipes.services;

import java.util.List;
import pl.destino.recipes.domain.Recipe;

/**
 *
 * @author Destino
 */
public interface RecipeService {

    List<Recipe> getRecipes();
}
