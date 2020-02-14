package sda.tema.SDA_Tema_4.controller.web.payload;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class NewTripDto implements Serializable {

    @NotNull
    private TripDetails tripDetails;
    @NotNull
    private FlightDetails flightDepartureDetails;
    @NotNull
    private FlightDetails flightReturnDetails;
    @NotNull
    private HotelDetails hotelDetails;

    public TripDetails getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(TripDetails tripDetails) {
        this.tripDetails = tripDetails;
    }

    public FlightDetails getFlightDepartureDetails() {
        return flightDepartureDetails;
    }

    public void setFlightDepartureDetails(FlightDetails flightDepartureDetails) {
        this.flightDepartureDetails = flightDepartureDetails;
    }

    public HotelDetails getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(HotelDetails hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public FlightDetails getFlightReturnDetails() {
        return flightReturnDetails;
    }

    public void setFlightReturnDetails(FlightDetails flightReturnDetails) {
        this.flightReturnDetails = flightReturnDetails;
    }
}
