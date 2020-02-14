package sda.tema.SDA_Tema_4.controller.web.payload;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class FlightDetails implements Serializable {

    @NotNull
    private AirportDetails airportDetails;
    private Integer numberOfSeets, retailabeSeats, price;
    @NotNull
    private String flightName;
    @NotNull
    @Future
    private Date departureDate;

    public AirportDetails getAirportDetails() {
        return airportDetails;
    }

    public void setAirportDetails(AirportDetails airportDetails) {
        this.airportDetails = airportDetails;
    }

    public Integer getNumberOfSeets() {
        return numberOfSeets;
    }

    public void setNumberOfSeets(Integer numberOfSeets) {
        this.numberOfSeets = numberOfSeets;
    }

    public Integer getRetailabeSeats() {
        return retailabeSeats;
    }

    public void setRetailabeSeats(Integer retailabeSeats) {
        this.retailabeSeats = retailabeSeats;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
