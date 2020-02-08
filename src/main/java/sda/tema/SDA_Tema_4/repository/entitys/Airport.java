package sda.tema.SDA_Tema_4.repository.entitys;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Airport")
public class Airport extends BaseEntity {

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "fk_airport_city"))
    private City city;

    @OneToMany(mappedBy = "airport")
    private List<Flight> listOfFlights;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Flight> getListOfFlights() {
        return listOfFlights;
    }

    public void setListOfFlights(List<Flight> listOfFlights) {
        this.listOfFlights = listOfFlights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name) &&
                Objects.equals(city, airport.city) &&
                Objects.equals(listOfFlights, airport.listOfFlights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, city, listOfFlights);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", city=" + city +
                ", listOfFlights=" + listOfFlights +
                '}';
    }
}
