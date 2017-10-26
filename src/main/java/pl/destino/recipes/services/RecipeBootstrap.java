package pl.destino.recipes.services;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.destino.recipes.domain.Ingredient;
import pl.destino.recipes.domain.Notes;
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

        Notes guacaNotes = new Notes();
        guacaNotes.setRecipe(guacamole);
        guacaNotes.setRecipeNotes("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n"
                + "\n"
                + "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n"
                + "\n"
                + "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n"
                + "\n"
                + "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n"
                + "\n"
                + "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n"
                + "\n"
                + "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n"
                + "\n"
                + "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n"
                + "\n"
                + "Variations\n"
                + "\n"
                + "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n"
                + "\n"
                + "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n"
                + "\n"
                + "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n"
                + "\n"
                + "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n"
                + "\n"
                + "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!\n"
                + "\n"
                + "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4wX3sHBho");

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
        tacos.setPrepTime(15);
        tacos.setCookTime(20);
        tacos.setServings(4);

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipe(guacamole);
        tacoNotes.setRecipeNotes("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
"\n" +
"2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
"\n" +
"Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
"\n" +
"3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
"\n" +
"4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
"\n" +
"Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
"\n" +
"5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
"\n" +
"Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4wXObzK5R");

        Set<Ingredient> tacoIngredients = new HashSet<Ingredient>();

        Ingredient chiliPowder = new Ingredient();
        chiliPowder.setAmount(BigDecimal.valueOf(2));
        chiliPowder.setDescription("ancho chili powder");
        chiliPowder.setRecipe(guacamole);
        if (uomTbsOptional.isPresent()) {
            chiliPowder.setUom(uomTbsOptional.orElseThrow(() -> {
                return new RuntimeException();
            }));
        }
        tacoIngredients.add(chiliPowder);

        tacoIngredients.add(salt);

        Ingredient cumin = new Ingredient();
        cumin.setAmount(BigDecimal.valueOf(1));
        cumin.setDescription("cumin");
        cumin.setRecipe(guacamole);
        if (uomTsOptional.isPresent()) {
            cumin.setUom(uomTsOptional.orElseThrow(() -> {
                return new RuntimeException();
            }));
        }
        tacoIngredients.add(cumin);

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

        Ingredient garlic = new Ingredient();
        garlic.setAmount(BigDecimal.valueOf(0.25));
        garlic.setDescription("clove garlic");
        garlic.setRecipe(guacamole);
        if (uomTsOptional.isPresent()) {
            garlic.setUom(uomDashOptional.orElseThrow(() -> {
                return new RuntimeException();
            }));
        }
        tacoIngredients.add(garlic);

        tacos.setIngredients(tacoIngredients);
        recipeRepository.save(tacos);

    }

}
