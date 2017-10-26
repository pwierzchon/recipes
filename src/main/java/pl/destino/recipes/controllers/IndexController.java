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
import pl.destino.recipes.services.RecipeService;

/**
 *
 * @author Destino
 */
@Controller
public class IndexController {
   
    private final RecipeService  recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    
    @RequestMapping({"","/","index"})
    public String getIndex(Model model) {

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

    
}
