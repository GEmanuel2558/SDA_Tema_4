package sda.tema.SDA_Tema_4.repository.entitys;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Room")
public class Room extends BaseEntity {

    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @Column(name = "available_double_rooms", columnDefinition = "INT(11) default 0 check (available_double_rooms >= 0)")
    private Integer numberOfAvailableDoubleRoom;

    @Column(name = "available_single_room", columnDefinition = "INT(11) default 0 check (available_single_room >= 0)")
    private Integer numberOfAvailableSingleRoom;

    @Column(name = "extra_beds", columnDefinition = "INT(11) default 0 check (extra_beds >= 0)")
    private Integer numberOfExtraBeds;

    @Column(name = "double_room_price", columnDefinition = "INT(11) default 0 check (double_room_price >= 0)")
    private Integer priceForDoubleRoom;

    @Column(name = "single_room_price", columnDefinition = "INT(11) default 0 check (single_room_price >= 0)")
    private Integer priceForSingleRoom;

    @Column(name = "extra_bed_price", columnDefinition = "INT(11) default 0 check (extra_bed_price >= 0)")
    private Integer pricePerExtraBed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_room_hotel"))
    private Hotel hotel;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date from_date) {
        this.fromDate = from_date;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date to_date) {
        this.toDate = to_date;
    }

    public Integer getNumberOfAvailableDoubleRoom() {
        return numberOfAvailableDoubleRoom;
    }

    public void setNumberOfAvailableDoubleRoom(Integer number_of_available_double_room) {
        this.numberOfAvailableDoubleRoom = number_of_available_double_room;
    }

    public Integer getNumberOfAvailableSingleRoom() {
        return numberOfAvailableSingleRoom;
    }

    public void setNumberOfAvailableSingleRoom(Integer number_of_available_single_room) {
        this.numberOfAvailableSingleRoom = number_of_available_single_room;
    }

    public Integer getNumberOfExtraBeds() {
        return numberOfExtraBeds;
    }

    public void setNumberOfExtraBeds(Integer number_of_extra_beds) {
        this.numberOfExtraBeds = number_of_extra_beds;
    }

    public Integer getPriceForDoubleRoom() {
        return priceForDoubleRoom;
    }

    public void setPriceForDoubleRoom(Integer price_for_double_room) {
        this.priceForDoubleRoom = price_for_double_room;
    }

    public Integer getPriceForSingleRoom() {
        return priceForSingleRoom;
    }

    public void setPriceForSingleRoom(Integer price_for_single_room) {
        this.priceForSingleRoom = price_for_single_room;
    }

    public Integer getPricePerExtraBed() {
        return pricePerExtraBed;
    }

    public void setPricePerExtraBed(Integer price_per_extra_bed) {
        this.pricePerExtraBed = price_per_extra_bed;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Transient
    public void decrementTheNumberOfDoubleRoomsBy(Integer decrementBy) {
        this.numberOfAvailableDoubleRoom = this.numberOfAvailableDoubleRoom - decrementBy;
    }

    @Transient
    public void decrementTheNumberOfSingleRoomsBy(Integer decrementBy) {
        this.numberOfAvailableSingleRoom = this.numberOfAvailableSingleRoom - decrementBy;
    }

    @Transient
    public void decrementTheNumberOfExtraBedsBy(Integer decrementBy) {
        this.numberOfExtraBeds = this.numberOfExtraBeds - decrementBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return Objects.equals(fromDate, room.fromDate) &&
                Objects.equals(toDate, room.toDate) &&
                Objects.equals(numberOfAvailableDoubleRoom, room.numberOfAvailableDoubleRoom) &&
                Objects.equals(numberOfAvailableSingleRoom, room.numberOfAvailableSingleRoom) &&
                Objects.equals(numberOfExtraBeds, room.numberOfExtraBeds) &&
                Objects.equals(priceForDoubleRoom, room.priceForDoubleRoom) &&
                Objects.equals(priceForSingleRoom, room.priceForSingleRoom) &&
                Objects.equals(pricePerExtraBed, room.pricePerExtraBed) &&
                Objects.equals(hotel, room.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fromDate, toDate, numberOfAvailableDoubleRoom, numberOfAvailableSingleRoom, numberOfExtraBeds, priceForDoubleRoom, priceForSingleRoom, pricePerExtraBed, hotel);
    }

    @Override
    public String toString() {
        return "Room{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", numberOfAvailableDoubleRoom=" + numberOfAvailableDoubleRoom +
                ", numberOfAvailableSingleRoom=" + numberOfAvailableSingleRoom +
                ", numberOfExtraBeds=" + numberOfExtraBeds +
                ", priceForDoubleRoom=" + priceForDoubleRoom +
                ", priceForSingleRoom=" + priceForSingleRoom +
                ", pricePerExtraBed=" + pricePerExtraBed +
                ", hotel=" + hotel +
                '}';
    }
}
