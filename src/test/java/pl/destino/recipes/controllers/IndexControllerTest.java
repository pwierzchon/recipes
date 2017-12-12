/*
 */
package pl.destino.recipes.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.destino.recipes.services.RecipeService;
import pl.destino.recipes.services.RecipeServiceImpl;

/**
 *
 * @author Destino
 */
public class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    /**
     * Test of getIndex method, of class IndexController.
     */
    @Test
    public void testGetIndex() {

        String result = indexController.getIndex(model);

        assertEquals("index", result);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1));
    }

}
