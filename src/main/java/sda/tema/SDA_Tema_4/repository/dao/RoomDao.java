package sda.tema.SDA_Tema_4.repository.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.repository.entitys.Room;

import java.util.Optional;

@Repository
public interface RoomDao extends CrudRepository<Room, Long> {

    @Modifying
    @Query(value = "update Room r set r.numberOfAvailableSingleRoom = :numberOfAvailableSingleRoom, " +
            "r.numberOfAvailableDoubleRoom = :numberOfAvailableDoubleRoom, r.numberOfExtraBeds = :numberOfExtraBeds " +
            "where r.id = :roomId")
    Integer updateRoom(@Param("roomId") Long roomId,
                              @Param("numberOfAvailableSingleRoom") Integer numberOfAvailableSingleRoom,
                              @Param("numberOfAvailableDoubleRoom") Integer numberOfAvailableDoubleRoom,
                              @Param("numberOfExtraBeds") Integer numberOfExtraBeds);

}
