package sda.tema.SDA_Tema_4.controller.web.payload;

import sda.tema.SDA_Tema_4.repository.entitys.Trip;
import sda.tema.SDA_Tema_4.security.entitys.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TripDetailsDto implements Serializable {

    private Integer numberOfDoubleRooms;
    private Integer numberOfSingleRooms;
    private Boolean extraBed;
    private Integer amount;
    private Long tripId;
    private String createdRow;

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

    public Boolean getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(Boolean extraBed) {
        this.extraBed = extraBed;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCreatedRow() {
        return createdRow;
    }

    public void setCreatedRow(String createdRow) {
        this.createdRow = createdRow;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDetailsDto that = (TripDetailsDto) o;
        return Objects.equals(numberOfDoubleRooms, that.numberOfDoubleRooms) &&
                Objects.equals(numberOfSingleRooms, that.numberOfSingleRooms) &&
                Objects.equals(extraBed, that.extraBed) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(tripId, that.tripId) &&
                Objects.equals(createdRow, that.createdRow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfDoubleRooms, numberOfSingleRooms, extraBed, amount, tripId, createdRow);
    }
}
