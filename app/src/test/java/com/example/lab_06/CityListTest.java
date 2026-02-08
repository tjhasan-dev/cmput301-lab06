package com.example.lab_06;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test class for CityList.
 * Tests the functionality of hasCity, delete, and countCities methods.
 */
public class CityListTest {
    private CityList cityList;
    private City city1;
    private City city2;
    private City city3;

    /**
     * Set up test fixtures before each test.
     * Creates a new CityList and sample City objects.
     */
    @Before
    public void setUp() {
        cityList = new CityList();
        city1 = new City("New York", 8000000);
        city2 = new City("Los Angeles", 4000000);
        city3 = new City("Chicago", 2700000);
    }

    /**
     * Test hasCity method when the city is in the list.
     */
    @Test
    public void testHasCityWhenCityExists() {
        cityList.add(city1);
        assertTrue("hasCity should return true for a city in the list",
                cityList.hasCity(city1));
    }

    /**
     * Test hasCity method when the city is not in the list.
     */
    @Test
    public void testHasCityWhenCityDoesNotExist() {
        cityList.add(city1);
        assertFalse("hasCity should return false for a city not in the list",
                cityList.hasCity(city2));
    }

    /**
     * Test hasCity with an equivalent city object.
     */
    @Test
    public void testHasCityWithEquivalentCity() {
        cityList.add(city1);
        City equivalentCity = new City("New York", 8000000);
        assertTrue("hasCity should return true for an equivalent city",
                cityList.hasCity(equivalentCity));
    }

    /**
     * Test hasCity with null parameter.
     */
    @Test
    public void testHasCityWithNull() {
        assertFalse("hasCity should return false for null",
                cityList.hasCity(null));
    }

    /**
     * Test hasCity on empty list.
     */
    @Test
    public void testHasCityOnEmptyList() {
        assertFalse("hasCity should return false on empty list",
                cityList.hasCity(city1));
    }

    /**
     * Test delete method successfully removes a city.
     */
    @Test
    public void testDeleteRemovesCityFromList() {
        cityList.add(city1);
        cityList.add(city2);

        assertEquals("List should have 2 cities before deletion",
                2, cityList.countCities());

        cityList.delete(city1);

        assertEquals("List should have 1 city after deletion",
                1, cityList.countCities());
        assertFalse("Deleted city should not be in the list",
                cityList.hasCity(city1));
        assertTrue("Other city should still be in the list",
                cityList.hasCity(city2));
    }

    /**
     * Test delete method throws exception when city is not in list.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteThrowsExceptionWhenCityNotFound() {
        cityList.add(city1);
        cityList.delete(city2);
    }

    /**
     * Test delete throws exception on empty list.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteThrowsExceptionOnEmptyList() {
        cityList.delete(city1);
    }

    /**
     * Test delete with equivalent city object.
     */
    @Test
    public void testDeleteWithEquivalentCity() {
        cityList.add(city1);
        City equivalentCity = new City("New York", 8000000);

        cityList.delete(equivalentCity);

        assertFalse("Deleted city should not be in the list",
                cityList.hasCity(city1));
        assertEquals("List should be empty after deletion",
                0, cityList.countCities());
    }

    /**
     * Test countCities on empty list.
     */
    @Test
    public void testCountCitiesOnEmptyList() {
        assertEquals("Empty list should have count of 0",
                0, cityList.countCities());
    }

    /**
     * Test countCities with one city.
     */
    @Test
    public void testCountCitiesWithOneCity() {
        cityList.add(city1);
        assertEquals("List with one city should have count of 1",
                1, cityList.countCities());
    }

    /**
     * Test countCities with multiple cities.
     */
    @Test
    public void testCountCitiesWithMultipleCities() {
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        assertEquals("List with three cities should have count of 3",
                3, cityList.countCities());
    }

    /**
     * Test countCities after adding and deleting cities.
     */
    @Test
    public void testCountCitiesAfterDeletion() {
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        assertEquals("Initial count should be 3",
                3, cityList.countCities());

        cityList.delete(city2);

        assertEquals("Count should be 2 after one deletion",
                2, cityList.countCities());

        cityList.delete(city1);

        assertEquals("Count should be 1 after two deletions",
                1, cityList.countCities());
    }

    /**
     * Test adding duplicate cities.
     */
    @Test
    public void testCountCitiesWithDuplicates() {
        cityList.add(city1);
        cityList.add(city1);
        assertEquals("List should count duplicate cities",
                2, cityList.countCities());
    }
}