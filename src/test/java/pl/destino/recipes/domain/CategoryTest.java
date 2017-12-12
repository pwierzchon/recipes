package pl.destino.recipes.domain;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Destino
 */
public class CategoryTest {

    Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    /**
     * Test of getId method, of class Category.
     */
    @Test
    public void testGetId() {
        Long idValue = 4l;
        category.setId(idValue);

        Assert.assertEquals(idValue, category.getId());
    }

}
