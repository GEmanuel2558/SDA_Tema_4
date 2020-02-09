package sda.tema.SDA_Tema_4.controller.web.payload;

import sda.tema.SDA_Tema_4.repository.entitys.Flight;

import java.io.Serializable;
import java.util.Date;

public class FlightDto implements Serializable {

    private String flightNumber;
    private Date departureDate;
    private Integer totalNumberOfSeets;
    private Integer retailabeSeats;
    private Integer flightPrice;
    private AirportDto airport;

    public FlightDto() {
    }

    public FlightDto(final Flight flight) {
        this.flightNumber = flight.getFlightNumber();
        this.departureDate = flight.getDepartureDate();
        this.totalNumberOfSeets = flight.getTotalNumberOfSeets();
        this.retailabeSeats = flight.getRetailabeSeats();
        this.flightPrice = flight.getFlightPrice();
        airport = new AirportDto(flight.getAirport());
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getTotalNumberOfSeets() {
        return totalNumberOfSeets;
    }

    public void setTotalNumberOfSeets(Integer totalNumberOfSeets) {
        this.totalNumberOfSeets = totalNumberOfSeets;
    }

    public Integer getRetailabeSeats() {
        return retailabeSeats;
    }

    public void setRetailabeSeats(Integer retailabeSeats) {
        this.retailabeSeats = retailabeSeats;
    }

    public Integer getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(Integer flightPrice) {
        this.flightPrice = flightPrice;
    }

    public AirportDto getAirport() {
        return airport;
    }

    public void setAirport(AirportDto airport) {
        this.airport = airport;
    }
}
