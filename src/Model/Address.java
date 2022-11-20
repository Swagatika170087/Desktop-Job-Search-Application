package Model;

import java.util.Objects;

public class Address {
    private String city;
    private String state;
    private String country;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getCity().equals(address.getCity()) && getState().equals(address.getState()) && getCountry().equals(address.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getState(), getCountry());
    }


}
