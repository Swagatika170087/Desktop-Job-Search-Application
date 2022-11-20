package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Location {
    private String country;
    private ArrayList<String> cities;

    public Location(String country, ArrayList<String> cities) {
        this.country = country;
        this.cities = cities;
    }

    public String getCountry() {
        return country;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getCountry().equals(location.getCountry()) && getCities().equals(location.getCities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getCities());
    }
}
