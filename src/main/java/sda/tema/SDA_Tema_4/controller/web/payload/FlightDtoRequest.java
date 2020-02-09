package sda.tema.SDA_Tema_4.controller.web.payload;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class FlightDtoRequest implements Serializable {

    private Date departureDate;
    @NotNull
    @Min(value = 6)
    private String flightNumber;
    @NotNull
    @Min(value = 10)
    private Integer flightPrice;
    @NotNull
    private Integer retailabeSeats;
    @NotNull
    private Integer numberOfSeets;
    @NotNull
    @Min(value = 2)
    private String airpotName;

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(Integer flightPrice) {
        this.flightPrice = flightPrice;
    }

    public Integer getRetailabeSeats() {
        return retailabeSeats;
    }

    public void setRetailabeSeats(Integer retailabeSeats) {
        this.retailabeSeats = retailabeSeats;
    }

    public Integer getNumberOfSeets() {
        return numberOfSeets;
    }

    public void setNumberOfSeets(Integer numberOfSeets) {
        this.numberOfSeets = numberOfSeets;
    }

    public String getAirpotName() {
        return airpotName;
    }

    public void setAirpotName(String airpotName) {
        this.airpotName = airpotName;
    }
}
