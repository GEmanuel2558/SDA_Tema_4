package sda.tema.SDA_Tema_4.repository.entitys;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "trip")
public class Trip extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "flight_id_departure", foreignKey = @ForeignKey(name = "fk_trip_flight_departure"))
    private Flight flightIdDeparture;

    @ManyToOne
    @JoinColumn(name = "flight_id_return", foreignKey = @ForeignKey(name = "fk_trip_flight_return"))
    private Flight flightIdReturn;

    @ManyToOne
    @JoinColumn(name = "hotel_id", foreignKey = @ForeignKey(name = "fk_trip_hotel"))
    private Hotel hotel;

    @Column(name = "checkin_to_hotel")
    //@Temporal(TemporalType.DATE)
    private Date checkinToHotel;

    @Column(name = "checkout_from_hotel")
    //@Temporal(TemporalType.DATE)
    private Date checkoutFromHotel;

    @Column
    private Boolean promoted;

    @OneToMany(mappedBy = "trip")
    private List<TripDetails> listOfTripDetails;

    public Trip() {

    }

    public Flight getFlightIdDeparture() {
        return flightIdDeparture;
    }

    public void setFlightIdDeparture(Flight flight_id_departure) {
        this.flightIdDeparture = flight_id_departure;
    }

    public Flight getFlightIdReturn() {
        return flightIdReturn;
    }

    public void setFlightIdReturn(Flight flight_id_return) {
        this.flightIdReturn = flight_id_return;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getCheckinToHotel() {
        return checkinToHotel;
    }

    public void setCheckinToHotel(Date checkin_from_hotel) {
        this.checkinToHotel = checkin_from_hotel;
    }

    public Date getCheckoutFromHotel() {
        return checkoutFromHotel;
    }

    public void setCheckoutFromHotel(Date checkout_from_holte) {
        this.checkoutFromHotel = checkout_from_holte;
    }

    public Boolean getPromoted() {
        return promoted;
    }

    public void setPromoted(Boolean promoted) {
        this.promoted = promoted;
    }

    public List<TripDetails> getListOfTripDetails() {
        return listOfTripDetails;
    }

    public void setListOfTripDetails(List<TripDetails> listOfTripDetails) {
        this.listOfTripDetails = listOfTripDetails;
    }

    @Transient
    public String getDepartureFlightNumber() {
        return this.getFlightIdDeparture().getFlightNumber();
    }

    @Transient
    public String getReturnFlightNumber() {
        return this.getFlightIdReturn().getFlightNumber();
    }

    @Transient
    public String getCityName() {
        return this.getHotel().getCity().getName();
    }

    @Transient
    public String getHotelName() {
        return this.getHotel().getName();
    }

    @Transient
    public String getDepartureAirportName() {
        return this.getFlightIdDeparture().getAirport().getName();
    }

    @Transient
    public String getReturnAirportName() {
        return this.getFlightIdReturn().getAirport().getName();
    }

    @Transient
    public String getContinentName() {
        return this.getHotel().getCity().getCountry().getContinent().getName();
    }

    @Transient
    public String getCountryName() {
        return this.getHotel().getCity().getCountry().getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Trip trip = (Trip) o;
        return Objects.equals(flightIdDeparture, trip.flightIdDeparture) &&
                Objects.equals(flightIdReturn, trip.flightIdReturn) &&
                Objects.equals(hotel, trip.hotel) &&
                Objects.equals(checkinToHotel, trip.checkinToHotel) &&
                Objects.equals(checkoutFromHotel, trip.checkoutFromHotel) &&
                Objects.equals(promoted, trip.promoted) &&
                Objects.equals(listOfTripDetails, trip.listOfTripDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flightIdDeparture, flightIdReturn, hotel, checkinToHotel, checkoutFromHotel, promoted, listOfTripDetails);
    }

/*    @Override
    public String toString() {
        return "Trip{" +
                "flightIdDeparture=" + flightIdDeparture +
                ", flightIdReturn=" + flightIdReturn +
                ", hotel=" + hotel +
                ", checkinFromHotel=" + checkinFromHotel +
                ", checkoutFromHotel=" + checkoutFromHotel +
                ", promoted=" + promoted +
                ", listOfTripDetails=" + listOfTripDetails +
                '}';
    }*/
}
