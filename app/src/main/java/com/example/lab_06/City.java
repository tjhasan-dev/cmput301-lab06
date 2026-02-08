package com.example.lab_06;

/**
 * Represents a city with a name and population.
 * This class provides basic information about a city including
 * its name and population count.
 *
 * @author Student
 * @version 1.0
 */
public class City {
    private String name;
    private int population;

    /**
     * Constructs a new City with the specified name and population.
     *
     * @param name the name of the city
     * @param population the population of the city
     */
    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    /**
     * Gets the name of the city.
     *
     * @return the name of the city
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the city.
     *
     * @param name the new name for the city
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the population of the city.
     *
     * @return the population count
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets the population of the city.
     *
     * @param population the new population count
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Compares this city to another object for equality.
     * Two cities are considered equal if they have the same name
     * and population.
     *
     * @param obj the object to compare with
     * @return true if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        City city = (City) obj;
        return population == city.population &&
                (name != null ? name.equals(city.name) : city.name == null);
    }

    /**
     * Returns a hash code value for the city.
     * The hash code is based on the city's name and population.
     *
     * @return a hash code value for this city
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + population;
        return result;
    }

    /**
     * Returns a string representation of the city.
     *
     * @return a string containing the city's name and population
     */
    @Override
    public String toString() {
        return "City{name='" + name + "', population=" + population + "}";
    }
}