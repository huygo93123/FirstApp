package models;

import java.io.Serializable;

/**
 * Created by Admin on 12/21/2017.
 */

public class Country implements Serializable {
    private String countryName;

    private String flagName;
    private int population;

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", population=" + population +
                '}';
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Country(String countryName, String flagName, int population) {

        this.countryName = countryName;
        this.flagName = flagName;
        this.population = population;
    }
}
