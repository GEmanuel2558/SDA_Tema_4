package sda.tema.SDA_Tema_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.business.TripService;
import sda.tema.SDA_Tema_4.repository.dao.TripDao;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ComponentScan("sda.tema.SDA_Tema_4.*")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DbTest {

    @Autowired
    private TripDao tripDao;


    @Autowired
    private TripService tripService;

    @Test
    public void givenParameters_ThanGetTrip() {
        //List<Trip> trip = tripDao.findTripByCriteria(new Date(), new Date(), "Emanuel", 5);
        //Assertions.assertEquals(0, trip.size());
    }

    @Test
    public void givenParameters_ThanGetTripId() {
        Optional<Trip> tripId = tripDao.findTripIdByCriteria("Emanuel", "a5f58r", "w8f2r6");
        Assertions.assertNull(tripId.get());
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void givenTripId_ThanDecrementRooms() {
        Long tripId = 1L;
        Integer numberOfDoubleRooms = 1;
        Integer numberOfSingleRooms = 1;
        Integer extraBed = 1;
        Optional<Trip> trip = tripDao.findById(tripId);
        Assertions.assertTrue(trip.isPresent());
        trip.get().getHotel().getListOfRooms()
                .stream()
                .filter(room -> (null == numberOfDoubleRooms || room.getNumberOfAvailableDoubleRoom() >= numberOfDoubleRooms)
                        && (null == numberOfSingleRooms || room.getNumberOfAvailableSingleRoom() >= numberOfSingleRooms)
                        && (null == extraBed || room.getNumberOfExtraBeds() >= extraBed))
                .findFirst().map(room -> {
            System.out.println("Pentru trip id = "+tripId+" am: "+room);
            return true;
        }).orElse(false);

        try {
            tripService.decrementTheNumberOfRooms(tripId, 1, 1, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
