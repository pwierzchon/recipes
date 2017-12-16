/*
 */
package pl.destino.recipes.repositories;

import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.destino.recipes.domain.UnitOfMeasure;

/**
 *
 * @author Destino
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
   
    @Autowired
    private UnitOfMeasureRepository measureRepository;
    
    public UnitOfMeasureRepositoryIT() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of findByDescription method, of class UnitOfMeasureRepository.
     */
    @Test
    public void testFindByDescription() {
        Optional<UnitOfMeasure> teaspoon = measureRepository.findByDescription("Teaspoon");
        
        assertEquals("Teaspoon", teaspoon.get().getDescription());
    }

    
}
