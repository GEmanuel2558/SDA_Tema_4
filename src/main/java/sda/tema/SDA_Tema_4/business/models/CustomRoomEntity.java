package sda.tema.SDA_Tema_4.business.models;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

public class CustomRoomEntity implements Serializable {

    private Long roomId;
    private Integer numberOfAvailableDoubleRoom, numberOfAvailableSingleRoom, numberOfExtraBeds;

    public CustomRoomEntity(Long roomId, Integer numberOfAvailableDoubleRoom, Integer numberOfAvailableSingleRoom, Integer numberOfExtraBeds) {
        this.roomId = roomId;
        this.numberOfAvailableDoubleRoom = numberOfAvailableDoubleRoom;
        this.numberOfAvailableSingleRoom = numberOfAvailableSingleRoom;
        this.numberOfExtraBeds = numberOfExtraBeds;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    public void decrementTheNumberOfDoubleRoomsBy(Integer decrementBy) {
        if (null != decrementBy) {
            this.numberOfAvailableDoubleRoom = this.numberOfAvailableDoubleRoom - decrementBy;
        }
    }

    public void decrementTheNumberOfSingleRoomsBy(Integer decrementBy) {
        if (null != decrementBy) {
            this.numberOfAvailableSingleRoom = this.numberOfAvailableSingleRoom - decrementBy;
        }
    }

    public void decrementTheNumberOfExtraBedsBy(Integer decrementBy) {
        if (null != decrementBy) {
            this.numberOfExtraBeds = this.numberOfExtraBeds - decrementBy;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomRoomEntity that = (CustomRoomEntity) o;
        return Objects.equals(roomId, that.roomId) &&
                Objects.equals(numberOfAvailableDoubleRoom, that.numberOfAvailableDoubleRoom) &&
                Objects.equals(numberOfAvailableSingleRoom, that.numberOfAvailableSingleRoom) &&
                Objects.equals(numberOfExtraBeds, that.numberOfExtraBeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, numberOfAvailableDoubleRoom, numberOfAvailableSingleRoom, numberOfExtraBeds);
    }

    @Override
    public String toString() {
        return "CustomRoomEntity{" +
                "roomId=" + roomId +
                ", numberOfAvailableDoubleRoom=" + numberOfAvailableDoubleRoom +
                ", numberOfAvailableSingleRoom=" + numberOfAvailableSingleRoom +
                ", numberOfExtraBeds=" + numberOfExtraBeds +
                '}';
    }
}
