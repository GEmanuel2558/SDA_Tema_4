package sda.tema.SDA_Tema_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sda.tema.SDA_Tema_4.repository.dao.TripDao;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;

import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ComponentScan("sda.tema.SDA_Tema_4.*")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DbTest {

    @Autowired
    private TripDao tripDao;

    @Test
    public void givenParameters_ThanGetTrip() {
        //List<Trip> trip = tripDao.findTripByCriteria(new Date(), new Date(), "Emanuel", 5);
        //Assertions.assertEquals(0, trip.size());
    }

    @Test
    public void givenParameters_ThanGetTripId() {
        Long tripId = tripDao.findTripIdByCriteria("Emanuel", "a5f58r", "w8f2r6");
        Assertions.assertNull(tripId);
    }

}
