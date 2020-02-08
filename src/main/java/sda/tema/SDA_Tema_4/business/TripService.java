package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDtoRequest;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDtoResponse;
import sda.tema.SDA_Tema_4.repository.dao.TripDao;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TripService {

    private final TripDao tripDao;

    public TripService(TripDao tripDao) {
        this.tripDao = tripDao;
    }

    @Transactional(readOnly = true)
    public List<TripDtoResponse> findTrip(TripDtoRequest request) throws IOException {
        List<Trip> listOfTrips = tripDao.findTripByCriteria(request.getFromDate(),
                request.getToDate(),
                request.getHotelName(),
                request.getCityName(),
                request.getNrOfPersons());
        if (null != listOfTrips) {
            List<TripDtoResponse> responseList = new ArrayList<>();
            for (Trip currentTrip : listOfTrips) {
                TripDtoResponse newTripDto = new TripDtoResponse();
                newTripDto.setCityName(currentTrip.getCityName());
                newTripDto.setHotelName(currentTrip.getHotelName());
                newTripDto.setFlightNumberDeparture(currentTrip.getDepartureFlightNumber());
                newTripDto.setFlightNumberReturn(currentTrip.getReturnFlightNumber());
                newTripDto.setAirportNameDeparture(currentTrip.getDepartureAirportName());
                newTripDto.setAirportNameReturn(currentTrip.getReturnAirportName());
                newTripDto.setContinentName(currentTrip.getContinentName());
                newTripDto.setCountryName(currentTrip.getCountryName());
                responseList.add(newTripDto);
            }
            return responseList;
        } else {
            throw new IOException("No records");
        }
    }




    /*cross origin resourcer, database replication, load balancing (nginx), high available, provisioning tools, service discovery (consul, eureka),
     elk (elastic seach log stash and kebana), spring cqrs
    * partra de containerezare, service bus, (eip) enterprice integration pattern, cozi de mesaje  (amqp, jms), quartz, */

}
