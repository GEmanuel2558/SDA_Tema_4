package sda.tema.SDA_Tema_4.repository.entitys;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hotel")
public class Hotel extends BaseEntity {

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String description;

    @Column
    private Integer standard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_hotel_city"))
    private City city;

    @OneToMany(mappedBy = "hotel")
    private List<Room> listOfRooms;

    @OneToMany(mappedBy = "hotel")
    private List<Trip> listOfTrips;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Room> getListOfRooms() {
        return listOfRooms;
    }

    public void setListOfRooms(List<Room> listOfRooms) {
        this.listOfRooms = listOfRooms;
    }

    public List<Trip> getListOfTrips() {
        return listOfTrips;
    }

    public void setListOfTrips(List<Trip> listOfTrips) {
        this.listOfTrips = listOfTrips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(name, hotel.name) &&
                Objects.equals(description, hotel.description) &&
                Objects.equals(standard, hotel.standard) &&
                Objects.equals(city, hotel.city) &&
                Objects.equals(listOfRooms, hotel.listOfRooms) &&
                Objects.equals(listOfTrips, hotel.listOfTrips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, standard, city, listOfRooms, listOfTrips);
    }

/*    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", standard=" + standard +
                ", city=" + city +
                ", listOfRooms=" + listOfRooms +
                ", listOfTrips=" + listOfTrips +
                '}';
    }*/
}
