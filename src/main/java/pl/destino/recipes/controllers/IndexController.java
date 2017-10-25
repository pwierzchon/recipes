package pl.destino.recipes.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import org.aspectj.weaver.Iterators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.destino.recipes.domain.Category;
import pl.destino.recipes.domain.Recipe;
import pl.destino.recipes.domain.UnitOfMeasure;
import pl.destino.recipes.repositories.CategoryRepository;
import pl.destino.recipes.repositories.RecipeRepository;
import pl.destino.recipes.repositories.UnitOfMeasureRepository;

/**
 *
 * @author Destino
 */
@Controller
public class IndexController {

    private final RecipeRepository recipeRepository;

    public IndexController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    
    
    
    @RequestMapping({"","/","index"})
    public String getIndex(Model model) {
        
        Iterable<Recipe> recipes = recipeRepository.findAll();
        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
        recipes.iterator().forEachRemaining(recipeList::add);
        model.addAttribute("recipes", recipeList);

        return "index";
    }

    
}
