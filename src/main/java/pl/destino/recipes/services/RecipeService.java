/*
 */
package pl.destino.recipes.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.destino.recipes.domain.Recipe;
import pl.destino.recipes.repositories.RecipeRepository;

/**
 *
 * @author Destino
 */
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes() {
        Iterable<Recipe> recipes = recipeRepository.findAll();
        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
        recipes.iterator().forEachRemaining(recipeList::add);
        return recipeList;
    }

}
