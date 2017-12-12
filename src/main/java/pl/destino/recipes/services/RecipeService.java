/*
 */
package pl.destino.recipes.services;

import java.util.Set;
import pl.destino.recipes.domain.Recipe;

/**
 *
 * @author Destino
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}
