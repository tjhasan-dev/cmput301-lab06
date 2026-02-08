package com.example.lab_06;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of City objects.
 * This class provides methods to add, remove, search, and count cities
 * in the list.
 *
 * @author Student
 * @version 1.0
 */
public class CityList {
    private List<City> cities;

    /**
     * Constructs a new empty CityList.
     * Initializes the internal list to store cities.
     */
    public CityList() {
        this.cities = new ArrayList<City>();
    }

    /**
     * Adds a city to the list.
     *
     * @param city the city to add to the list
     * @return true if the city was successfully added, false otherwise
     */
    public boolean add(City city) {
        if (city == null) {
            return false;
        }
        return cities.add(city);
    }

    /**
     * Checks whether a given city is present in the list.
     * Uses the equals method to compare cities.
     *
     * @param city the city to search for
     * @return true if the city is in the list, false otherwise
     */
    public boolean hasCity(City city) {
        if (city == null) {
            return false;
        }
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list.
     * If the city is present in the list, it is removed.
     * If the city is not present, an IllegalArgumentException is thrown.
     *
     * @param city the city to delete from the list
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        if (!hasCity(city)) {
            throw new IllegalArgumentException("City not found in the list");
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities currently in the list.
     *
     * @return the count of cities in the list
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Gets all cities in the list.
     *
     * @return a list containing all cities
     */
    public List<City> getCities() {
        return new ArrayList<City>(cities);
    }

    /**
     * Clears all cities from the list.
     */
    public void clear() {
        cities.clear();
    }

    /**
     * Returns a string representation of the city list.
     *
     * @return a string containing all cities in the list
     */
    @Override
    public String toString() {
        return "CityList{cities=" + cities + "}";
    }
}