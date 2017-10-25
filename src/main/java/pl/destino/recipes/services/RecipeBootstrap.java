package pl.destino.recipes.services;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.destino.recipes.domain.Ingredient;
import pl.destino.recipes.domain.Recipe;
import pl.destino.recipes.domain.UnitOfMeasure;
import pl.destino.recipes.enums.Difficulty;
import pl.destino.recipes.repositories.CategoryRepository;
import pl.destino.recipes.repositories.RecipeRepository;
import pl.destino.recipes.repositories.UnitOfMeasureRepository;

/**
 *
 * @author Destino
 */
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createRecipes();
    }

    private void createRecipes() {
        System.out.println("create recipes");
        Recipe guacamole = new Recipe();
        guacamole.setDescription("Guacamole");
        recipeRepository.save(guacamole);

        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setPrepTime(10);
        guacamole.setServings(4);

        Set<Ingredient> guacamoleIngredients = new HashSet<Ingredient>();

        Ingredient avocado = new Ingredient();
        avocado.setAmount(BigDecimal.valueOf(2));
        avocado.setDescription("avocado");
        avocado.setRecipe(guacamole);
        guacamoleIngredients.add(avocado);

        Ingredient salt = new Ingredient();
        salt.setAmount(BigDecimal.valueOf(0.5));
        salt.setDescription("salt");
        salt.setRecipe(guacamole);
        Optional<UnitOfMeasure> uomTsOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (uomTsOptional.isPresent()) {
            salt.setUom(uomTsOptional.orElseThrow(() -> {
                return new RuntimeException();
            }));
        }
        guacamoleIngredients.add(salt);

        Ingredient lemonJuice = new Ingredient();
        lemonJuice.setAmount(BigDecimal.valueOf(1));
        lemonJuice.setDescription("lime or lemon juice");
        lemonJuice.setRecipe(guacamole);
        Optional<UnitOfMeasure> uomTbsOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (uomTbsOptional.isPresent()) {
            lemonJuice.setUom(uomTbsOptional.orElseThrow(() -> {
                return new RuntimeException();
            }));
        }
        guacamoleIngredients.add(lemonJuice);

        Ingredient onion = new Ingredient();
        onion.setAmount(BigDecimal.valueOf(0.25));
        onion.setDescription("minced red onion");
        onion.setRecipe(guacamole);
        Optional<UnitOfMeasure> uomCupOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (uomTsOptional.isPresent()) {
            onion.setUom(uomCupOptional.orElseThrow(() -> {
                return new RuntimeException();
            }));
        }
        guacamoleIngredients.add(onion);

        Ingredient chili = new Ingredient();
        chili.setAmount(BigDecimal.valueOf(2));
        chili.setDescription("serrano chilles");
        chili.setRecipe(guacamole);
        guacamoleIngredients.add(chili);

        Ingredient pepper = new Ingredient();
        pepper.setAmount(BigDecimal.valueOf(0.25));
        pepper.setDescription("minced red onion");
        pepper.setRecipe(guacamole);
        Optional<UnitOfMeasure> uomDashOptional = unitOfMeasureRepository.findByDescription("Dash");
        if (uomTsOptional.isPresent()) {
            pepper.setUom(uomDashOptional.orElseThrow(() -> {
                return new RuntimeException();
            }));
        }
        guacamoleIngredients.add(pepper);

        guacamole.setIngredients(guacamoleIngredients);
        recipeRepository.save(guacamole);
        
        Recipe tacos = new Recipe();
        tacos.setDescription("Spicy Grilled Chicken Tacos");
        recipeRepository.save(tacos);

        tacos.setDifficulty(Difficulty.EASY);
        tacos.setPrepTime(10);
        tacos.setServings(4);

        Set<Ingredient> tacoIngredients = new HashSet<Ingredient>();

        avocado.setAmount(BigDecimal.valueOf(2));
        avocado.setDescription("avocado");
        avocado.setRecipe(guacamole);
        tacoIngredients.add(avocado);

        salt.setAmount(BigDecimal.valueOf(0.5));
        salt.setDescription("salt");
        salt.setRecipe(guacamole);
        if (uomTsOptional.isPresent()) {
            salt.setUom(uomTsOptional.orElseThrow(() -> {
                return new RuntimeException();
            }));
        }
        tacoIngredients.add(salt);

        lemonJuice.setAmount(BigDecimal.valueOf(1));
        lemonJuice.setDescription("lime or lemon juice");
        lemonJuice.setRecipe(guacamole);
        if (uomTbsOptional.isPresent()) {
            lemonJuice.setUom(uomTbsOptional.orElseThrow(() -> {
                return new RuntimeException();
            }));
        }
        tacoIngredients.add(lemonJuice);

        onion.setAmount(BigDecimal.valueOf(0.25));
        onion.setDescription("minced red onion");
        onion.setRecipe(guacamole);
        if (uomTsOptional.isPresent()) {
            onion.setUom(uomCupOptional.orElseThrow(() -> {
                return new RuntimeException();
            }));
        }
        tacoIngredients.add(onion);

        chili.setAmount(BigDecimal.valueOf(2));
        chili.setDescription("serrano chilles");
        chili.setRecipe(guacamole);
        tacoIngredients.add(chili);

        pepper.setAmount(BigDecimal.valueOf(0.25));
        pepper.setDescription("minced red onion");
        pepper.setRecipe(guacamole);
        if (uomTsOptional.isPresent()) {
            pepper.setUom(uomDashOptional.orElseThrow(() -> {
                return new RuntimeException();
            }));
        }
        tacoIngredients.add(pepper);

        tacos.setIngredients(tacoIngredients);
        recipeRepository.save(tacos);

    }

}
