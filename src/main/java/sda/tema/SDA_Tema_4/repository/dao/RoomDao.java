package sda.tema.SDA_Tema_4.repository.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.repository.entitys.Room;

import java.util.List;

@Repository
public interface RoomDao extends CrudRepository<Room, Long> {

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "update Room r set r.numberOfAvailableSingleRoom = :numberOfAvailableSingleRoom where r.id = :roomId")
    void updateRoom(@Param("roomId") Long roomId,
                    @Param("numberOfAvailableSingleRoom") Integer numberOfAvailableSingleRoom);

    @Query(value = "select r from Room r where r.hotel.name = :hotelName")
    List<Room> getAllRoomsForHotel(@Param("hotelName") String hotelName);

}
