package chachaup.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //tests if an animal object instantiates correctly
    @Test
    void animal_instantiatesCorrectly() {
        Animal animal = new Animal("banana");
        assertTrue(animal instanceof Animal);
    }

    //tests if creating an object really takes the values
    @Test
    void animal_instantiatesWithParams() {
        Animal animal = new Animal("banana");
        assertEquals("banana",animal.getAnimalName());
    }

    //test if equals and hashcode works
    @Test
    void equals_twoSimilarObjectsCompare_true() {
        Animal animal = new Animal("banana");
        Animal animal1 = new Animal("banana");
        assertTrue(animal.equals(animal1));
    }

    //tests saving and reading data from database
    @Test
    void save_AnimalSavedToDbSuccessfully() {
        Animal animal = new Animal("banana");
        animal.save();
        assertEquals("banana",Animal.getAll().get(0).getAnimalName());
    }

    @Test
    void animal_findsAndReturnsWithSimilarId_true() {
        Animal animal = new Animal( "banana");
        animal.save();
        System.out.println(animal.getId());
        assertEquals(animal, Animal.findById(animal.getId()));

    }
}