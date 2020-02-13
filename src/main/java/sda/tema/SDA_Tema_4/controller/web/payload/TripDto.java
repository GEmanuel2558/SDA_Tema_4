package sda.tema.SDA_Tema_4.controller.web.payload;

import sda.tema.SDA_Tema_4.repository.entitys.Trip;

import java.io.Serializable;

public class TripDto implements Serializable {

    private FlightDtoResponse flightIdDeparture;
    private FlightDtoResponse flightIdReturn;
    private HotelDto hotel;
    private String checkinFromHotel;
    private String checkoutFromHotel;
    private Boolean promoted;

    public TripDto() {
    }

    public TripDto(final Trip trip) {
        checkinFromHotel = trip.getCheckinToHotel().toString();
        checkoutFromHotel = trip.getCheckoutFromHotel().toString();
        promoted = trip.getPromoted();
        //Cobalt pentru bateriile de masina si cauta sa faca o celula de hidrogen
        flightIdDeparture = new FlightDtoResponse(trip.getFlightIdDeparture());
        flightIdReturn = new FlightDtoResponse(trip.getFlightIdReturn());
        hotel = new HotelDto(trip.getHotel());
    }

    public FlightDtoResponse getFlightIdDeparture() {
        return flightIdDeparture;
    }

    public void setFlightIdDeparture(FlightDtoResponse flightIdDeparture) {
        this.flightIdDeparture = flightIdDeparture;
    }

    public FlightDtoResponse getFlightIdReturn() {
        return flightIdReturn;
    }

    public void setFlightIdReturn(FlightDtoResponse flightIdReturn) {
        this.flightIdReturn = flightIdReturn;
    }

    public HotelDto getHotel() {
        return hotel;
    }

    public void setHotel(HotelDto hotel) {
        this.hotel = hotel;
    }

    public String getCheckinFromHotel() {
        return checkinFromHotel;
    }

    public void setCheckinFromHotel(String checkinFromHotel) {
        this.checkinFromHotel = checkinFromHotel;
    }

    public String getCheckoutFromHotel() {
        return checkoutFromHotel;
    }

    public void setCheckoutFromHotel(String checkoutFromHotel) {
        this.checkoutFromHotel = checkoutFromHotel;
    }

    public Boolean getPromoted() {
        return promoted;
    }

    public void setPromoted(Boolean promoted) {
        this.promoted = promoted;
    }
}
