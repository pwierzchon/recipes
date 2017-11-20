/*
 */
package pl.destino.recipes.services;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.destino.recipes.domain.Recipe;
import pl.destino.recipes.repositories.RecipeRepository;

/**
 *
 * @author Destino
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes() {
        log.info("---Get Recipes---");
        Iterable<Recipe> recipes = recipeRepository.findAll();     
        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
        recipes.iterator().forEachRemaining(recipeList::add);
        log.info("Recipes found: {}",recipeList.size());
        log.info("---Get Recipes---");
        return recipeList;
    }

}
