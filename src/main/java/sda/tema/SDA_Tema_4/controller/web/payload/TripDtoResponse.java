package sda.tema.SDA_Tema_4.controller.web.payload;

import java.io.Serializable;

public class TripDtoResponse implements Serializable {

    private String continentName,
            cityName,
            countryName,
            hotelName,
            airportNameDeparture,
            airportNameReturn,
            flightNumberDeparture,
            flightNumberReturn;
    private Integer numberOfDoubleRooms, numberOfSingleRooms, amount, extraBed, numberOfPersons;

    private Long roomId;

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getAirportNameDeparture() {
        return airportNameDeparture;
    }

    public void setAirportNameDeparture(String airportNameDeparture) {
        this.airportNameDeparture = airportNameDeparture;
    }

    public String getAirportNameReturn() {
        return airportNameReturn;
    }

    public void setAirportNameReturn(String airportNameReturn) {
        this.airportNameReturn = airportNameReturn;
    }

    public String getFlightNumberDeparture() {
        return flightNumberDeparture;
    }

    public void setFlightNumberDeparture(String flightNumberDeparture) {
        this.flightNumberDeparture = flightNumberDeparture;
    }

    public String getFlightNumberReturn() {
        return flightNumberReturn;
    }

    public void setFlightNumberReturn(String flightNumberReturn) {
        this.flightNumberReturn = flightNumberReturn;
    }

    public Integer getNumberOfDoubleRooms() {
        return numberOfDoubleRooms;
    }

    public void setNumberOfDoubleRooms(Integer numberOfDoubleRooms) {
        this.numberOfDoubleRooms = numberOfDoubleRooms;
    }

    public Integer getNumberOfSingleRooms() {
        return numberOfSingleRooms;
    }

    public void setNumberOfSingleRooms(Integer numberOfSingleRooms) {
        this.numberOfSingleRooms = numberOfSingleRooms;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(Integer extraBed) {
        this.extraBed = extraBed;
    }

    public Integer getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(Integer numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}
