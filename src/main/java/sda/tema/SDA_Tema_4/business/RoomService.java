package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.exceptions.NoMoreHotelRoomsException;
import sda.tema.SDA_Tema_4.repository.dao.RoomDao;
import sda.tema.SDA_Tema_4.repository.entitys.Room;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomDao roomDao;

    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void updateRoom(final Room updateEntity) {
/*        roomDao.updateRoom(updateEntity.getId(),
                updateEntity.getNumberOfAvailableSingleRoom(),
                updateEntity.getNumberOfAvailableDoubleRoom(),
                updateEntity.getNumberOfExtraBeds());*/

/*        roomDao.findById(updateEntity.getId()).map(room -> {
            room.setNumberOfAvailableSingleRoom(updateEntity.getNumberOfAvailableSingleRoom());
            room.setNumberOfAvailableDoubleRoom(updateEntity.getNumberOfAvailableDoubleRoom());
            room.setNumberOfExtraBeds(updateEntity.getNumberOfExtraBeds());
            return true;
        }).orElseThrow(NoMoreHotelRoomsException::new);*/

        roomDao.updateRoom(13L,
                0);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public List<Room> getAllRoomsForHotel(String hotelName) {
        return roomDao.getAllRoomsForHotel(hotelName);
    }

    private AtomicInteger tmpNumberOfExtraBeds = new AtomicInteger();

    @Transactional(propagation = Propagation.MANDATORY)
    public void decrementTheNumberOfRooms(final String hotelName,
                                          final Integer numberOfDoubleRooms,
                                          final Integer numberOfSingleRooms,
                                          final Integer numberOfExtraBeds) {

        List<Room> hotelRooms = getAllRoomsForHotel(hotelName);
        if (null == hotelName || hotelRooms.isEmpty()) {
            throw new NoMoreHotelRoomsException();
        } else {
            tmpNumberOfExtraBeds.set(numberOfExtraBeds);
            //decrementOnlyTheSingleRooms(numberOfSingleRooms, hotelRooms);
            hotelRooms.get(0).setNumberOfAvailableDoubleRoom(0);
            hotelRooms.get(0).setNumberOfAvailableSingleRoom(0);

        }

    }

    //@Transactional(propagation = Propagation.MANDATORY)
    public void decrementOnlyTheSingleRooms(Integer numberOfSingleRooms, List<Room> hotelRooms) {
        if (0 != numberOfSingleRooms) {
            List<Room> hotelAllSingleRooms = hotelRooms
                    .stream()
                    .filter(room -> 1 == room.getNumberOfAvailableSingleRoom())
                    .limit(numberOfSingleRooms)
                    .collect(Collectors.toList());
            if (hotelAllSingleRooms.size() < numberOfSingleRooms) {
                throw new NoMoreHotelRoomsException();
            } else {
                for(Room currentRoom : hotelAllSingleRooms) {
                    currentRoom.setNumberOfAvailableSingleRoom(0);
                    if (0 != tmpNumberOfExtraBeds.get()) {
                        switch (Integer.compare(currentRoom.getNumberOfExtraBeds(), tmpNumberOfExtraBeds.get())) {
                            case 0:
                                currentRoom.setNumberOfExtraBeds(0);
                                tmpNumberOfExtraBeds.set(0);
                                break;
                            case 1:
                                currentRoom.setNumberOfExtraBeds(currentRoom.getNumberOfExtraBeds() - tmpNumberOfExtraBeds.get());
                                tmpNumberOfExtraBeds.set(0);
                                break;
                            case -1:
                                int roomDifference = tmpNumberOfExtraBeds.get() - currentRoom.getNumberOfExtraBeds();
                                currentRoom.setNumberOfExtraBeds(roomDifference);
                                tmpNumberOfExtraBeds.set(roomDifference);
                                break;
                        }
                    }
                    updateRoom(currentRoom);
                }
            }
        }
    }


}
