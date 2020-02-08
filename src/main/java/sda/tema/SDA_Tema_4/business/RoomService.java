package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.repository.dao.RoomDao;
import sda.tema.SDA_Tema_4.repository.entitys.Room;

@Service
public class RoomService {

    private final RoomDao roomDao;

    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Integer updateRoom(final Long idToUpdate, final Room updateEntity) {
        return roomDao.updateRoom(idToUpdate,
                updateEntity.getNumberOfAvailableSingleRoom(),
                updateEntity.getNumberOfAvailableDoubleRoom(),
                updateEntity.getNumberOfExtraBeds());
    }

}
