package sda.tema.SDA_Tema_4.repository.entitys;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "City")
public class City extends BaseEntity {

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_country_city"))
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Hotel> listOfHotels;

    @OneToMany(mappedBy = "city")
    private List<Airport> listOfAirports;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Hotel> getListOfHotels() {
        return listOfHotels;
    }

    public void setListOfHotels(List<Hotel> listOfHotels) {
        this.listOfHotels = listOfHotels;
    }

    public List<Airport> getListOfAirports() {
        return listOfAirports;
    }

    public void setListOfAirports(List<Airport> listOfAirports) {
        this.listOfAirports = listOfAirports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) &&
                Objects.equals(country, city.country) &&
                Objects.equals(listOfHotels, city.listOfHotels) &&
                Objects.equals(listOfAirports, city.listOfAirports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, country, listOfHotels, listOfAirports);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country=" + country +
                ", listOfHotels=" + listOfHotels +
                ", listOfAirports=" + listOfAirports +
                '}';
    }
}
