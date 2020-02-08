package sda.tema.SDA_Tema_4.repository.entitys;

import sda.tema.SDA_Tema_4.security.entitys.User;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Trip_Details")
public class TripDetails extends BaseEntity {

    @Column
    private Integer number_of_double_rooms;

    @Column
    private Integer number_of_single_rooms;

    @Column
    private Boolean extra_bed;

    @Column
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "trip_id", foreignKey = @ForeignKey(name = "fk_trip_trip_details"))
    private Trip trip;

    @ManyToMany
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_trip_details_user"))
    private List<User> listOfUsers;

    public Integer getNumber_of_double_rooms() {
        return number_of_double_rooms;
    }

    public void setNumber_of_double_rooms(Integer number_of_double_rooms) {
        this.number_of_double_rooms = number_of_double_rooms;
    }

    public Integer getNumber_of_single_rooms() {
        return number_of_single_rooms;
    }

    public void setNumber_of_single_rooms(Integer number_of_single_rooms) {
        this.number_of_single_rooms = number_of_single_rooms;
    }

    public Boolean getExtra_bed() {
        return extra_bed;
    }

    public void setExtra_bed(Boolean extra_bed) {
        this.extra_bed = extra_bed;
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
        return Objects.equals(number_of_double_rooms, that.number_of_double_rooms) &&
                Objects.equals(number_of_single_rooms, that.number_of_single_rooms) &&
                Objects.equals(extra_bed, that.extra_bed) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(trip, that.trip) &&
                Objects.equals(listOfUsers, that.listOfUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number_of_double_rooms, number_of_single_rooms, extra_bed, amount, trip, listOfUsers);
    }

    @Override
    public String toString() {
        return "TripDetails{" +
                "number_of_double_rooms=" + number_of_double_rooms +
                ", number_of_single_rooms=" + number_of_single_rooms +
                ", extra_bed=" + extra_bed +
                ", amount=" + amount +
                ", trip=" + trip +
                ", listOfUsers=" + listOfUsers +
                '}';
    }
}
