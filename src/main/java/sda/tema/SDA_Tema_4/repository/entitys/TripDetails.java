package sda.tema.SDA_Tema_4.repository.entitys;

import sda.tema.SDA_Tema_4.security.entitys.User;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Trip_Details")
public class TripDetails extends BaseEntity {

    @Column(name = "number_of_double_rooms")
    private Integer numberOfDoubleRooms;

    @Column(name = "number_of_single_rooms")
    private Integer numberOfSingleRooms;

    @Column(name = "extra_bed")
    private Boolean extraBed;

    @Column
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "trip_id", foreignKey = @ForeignKey(name = "fk_trip_trip_details"))
    private Trip trip;

    @ManyToMany
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_trip_details_user"))
    private List<User> listOfUsers;

    public Integer getNumberOfDoubleRooms() {
        return numberOfDoubleRooms;
    }

    public void setNumberOfDoubleRooms(Integer number_of_double_rooms) {
        this.numberOfDoubleRooms = number_of_double_rooms;
    }

    public Integer getNumberOfSingleRooms() {
        return numberOfSingleRooms;
    }

    public void setNumberOfSingleRooms(Integer number_of_single_rooms) {
        this.numberOfSingleRooms = number_of_single_rooms;
    }

    public Boolean getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(Boolean extra_bed) {
        this.extraBed = extra_bed;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer ammount) {
        this.amount = ammount;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TripDetails that = (TripDetails) o;
        return Objects.equals(numberOfDoubleRooms, that.numberOfDoubleRooms) &&
                Objects.equals(numberOfSingleRooms, that.numberOfSingleRooms) &&
                Objects.equals(extraBed, that.extraBed) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(trip, that.trip) &&
                Objects.equals(listOfUsers, that.listOfUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfDoubleRooms, numberOfSingleRooms, extraBed, amount, trip, listOfUsers);
    }

    @Override
    public String toString() {
        return "TripDetails{" +
                "number_of_double_rooms=" + numberOfDoubleRooms +
                ", number_of_single_rooms=" + numberOfSingleRooms +
                ", extra_bed=" + extraBed +
                ", amount=" + amount +
                ", trip=" + trip +
                ", listOfUsers=" + listOfUsers +
                '}';
    }
}
