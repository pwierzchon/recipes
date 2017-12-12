/*
 */
package pl.destino.recipes.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import pl.destino.recipes.domain.Recipe;
import pl.destino.recipes.repositories.RecipeRepository;

/**
 *
 * @author Destino
 */
public class RecipeServiceImplTest {

    RecipeServiceImpl service;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new RecipeServiceImpl(recipeRepository);
    }

    /**
     * Test of getRecipes method, of class RecipeServiceImpl.
     */
    @Test
    public void testGetRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeL = new HashSet<>();
        recipeL.add(recipe);
        
        when(service.getRecipes()).thenReturn(recipeL);
        
        Set<Recipe> recipes = service.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository,times(1)).findAll();
        
    }

}
