package sda.tema.SDA_Tema_4.controller.web.payload;

import sda.tema.SDA_Tema_4.repository.entitys.Room;

import java.io.Serializable;
import java.util.Date;

public class RoomDto implements Serializable {

    private Date fromDate;
    private Date toDate;
    private Integer numberOfAvailableDoubleRoom;
    private Integer numberOfAvailableSingleRoom;
    private Integer numberOfExtraBeds;
    private Integer priceForDoubleRoom;
    private Integer priceForSingleRoom;
    private Integer pricePerExtraBed;

    public RoomDto() {

    }

    public RoomDto(final Room room) {
        fromDate = room.getFromDate();
        toDate = room.getToDate();
        numberOfAvailableDoubleRoom = room.getNumberOfAvailableDoubleRoom();
        numberOfAvailableSingleRoom = room.getNumberOfAvailableSingleRoom();
        numberOfExtraBeds = room.getNumberOfExtraBeds();
        priceForDoubleRoom = room.getPriceForDoubleRoom();
        priceForSingleRoom = room.getPriceForSingleRoom();
        pricePerExtraBed = room.getPricePerExtraBed();
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getNumberOfAvailableDoubleRoom() {
        return numberOfAvailableDoubleRoom;
    }

    public void setNumberOfAvailableDoubleRoom(Integer numberOfAvailableDoubleRoom) {
        this.numberOfAvailableDoubleRoom = numberOfAvailableDoubleRoom;
    }

    public Integer getNumberOfAvailableSingleRoom() {
        return numberOfAvailableSingleRoom;
    }

    public void setNumberOfAvailableSingleRoom(Integer numberOfAvailableSingleRoom) {
        this.numberOfAvailableSingleRoom = numberOfAvailableSingleRoom;
    }

    public Integer getNumberOfExtraBeds() {
        return numberOfExtraBeds;
    }

    public void setNumberOfExtraBeds(Integer numberOfExtraBeds) {
        this.numberOfExtraBeds = numberOfExtraBeds;
    }

    public Integer getPriceForDoubleRoom() {
        return priceForDoubleRoom;
    }

    public void setPriceForDoubleRoom(Integer priceForDoubleRoom) {
        this.priceForDoubleRoom = priceForDoubleRoom;
    }

    public Integer getPriceForSingleRoom() {
        return priceForSingleRoom;
    }

    public void setPriceForSingleRoom(Integer priceForSingleRoom) {
        this.priceForSingleRoom = priceForSingleRoom;
    }

    public Integer getPricePerExtraBed() {
        return pricePerExtraBed;
    }

    public void setPricePerExtraBed(Integer pricePerExtraBed) {
        this.pricePerExtraBed = pricePerExtraBed;
    }
}
