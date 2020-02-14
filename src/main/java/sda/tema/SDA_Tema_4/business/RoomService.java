package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.business.models.CustomRoomEntity;
import sda.tema.SDA_Tema_4.repository.dao.RoomDao;
import sda.tema.SDA_Tema_4.repository.entitys.Room;

import java.util.List;

@Service
public class RoomService {

    private final RoomDao roomDao;

    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Integer updateRoom(final CustomRoomEntity updateEntity) {
        return roomDao.updateRoom(updateEntity.getRoomId(),
                updateEntity.getNumberOfAvailableSingleRoom(),
                updateEntity.getNumberOfAvailableDoubleRoom(),
                updateEntity.getNumberOfExtraBeds());
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public List<Room> getAllRoomsForHotel(String hotelName) {
        return roomDao.getAllRoomsForHotel(hotelName);
    }

}
