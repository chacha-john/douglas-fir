package chachaup.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndangeredTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void endangeredAnimal_instantiatesCorrectly() {
        Endangered endangered = new Endangered("monster","healthy",12);
        assertTrue(endangered instanceof Endangered);
    }

    //can save into and read from database
    @Test
    void endangeredAnimal_instantiatesCorrectlyWithArguments() {
        Endangered endangered = new Endangered("monster","healthy",12);
        endangered.save();
        System.out.println(Endangered.all().size());
        assertEquals(endangered.getId(), Endangered.all().get(Endangered.all().size()-1).getId());
    }

    //can get item from database using id
    @Test
    void endangered_findById() {
        Endangered endangered = new Endangered("monster","healthy",12);
        endangered.save();
        assertEquals(endangered,Endangered.searchById(endangered.getId()));
    }
}