/*
 */
package pl.destino.recipes.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public Set<Recipe> getRecipes() {
        log.info("---Get Recipes---");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add); 
        log.info("Recipes found: {}",recipeSet.size());
        log.info("---Get Recipes---");
        return recipeSet;
    }

    
}
