package sda.tema.SDA_Tema_4.business;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.NewTripDto;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDto;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDtoRequest;
import sda.tema.SDA_Tema_4.exceptions.NoMoreHotelRoomsException;
import sda.tema.SDA_Tema_4.exceptions.NoTripsForTheSpecifiedPropertiesException;
import sda.tema.SDA_Tema_4.repository.dao.TripDao;
import sda.tema.SDA_Tema_4.repository.entitys.Flight;
import sda.tema.SDA_Tema_4.repository.entitys.Hotel;
import sda.tema.SDA_Tema_4.repository.entitys.Room;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TripService {

    private final TripDao tripDao;
    private final RoomService roomService;
    private final HotelService hotelDetails;
    private final FlightService flightService;

    public TripService(TripDao tripDao,
                       RoomService roomService,
                       HotelService hotelDetails,
                       FlightService flightService) {
        this.tripDao = tripDao;
        this.roomService = roomService;
        this.hotelDetails = hotelDetails;
        this.flightService = flightService;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<TripDto> findTripsByCriteria(Pageable pageable, TripDtoRequest request) {
        List<Trip> listOfTrips = tripDao.findTripByCriteria(request.getFromDate(),
                request.getToDate(),
                request.getHotelName(),
                request.getCityName(),
                request.getNrOfPersons().longValue());

        if (null != listOfTrips) {
            int listSize = listOfTrips.size();
            return listOfTrips
                    .stream()
                    .limit((listSize + pageable.getPageNumber() - 1) / pageable.getPageSize())
                    .map(TripDto::new).collect(Collectors.toList());
        } else {
            throw new NoTripsForTheSpecifiedPropertiesException();
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    Optional<List<Trip>> findTripIdByCriteria(String hotelName,
                                        String departureFlightNumber,
                                        String returnFlightNumber) {
        return this.tripDao.findTripIdByCriteria(hotelName, departureFlightNumber, returnFlightNumber);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public Optional<List<TripDto>> findTripsOnlyByPageant(@PageableDefault Pageable pageable) {
        return Optional.of(this.tripDao.findAll(pageable).stream().map(TripDto::new).collect(Collectors.toList()));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Long insertNewTrip(NewTripDto request) {
        Hotel hotel = hotelDetails.getHotel(request.getHotelDetails());
        Flight departureFlight = flightService.insertNewFlight(request.getFlightDepartureDetails());
        Flight returnFlight = flightService.insertNewFlight(request.getFlightReturnDetails());
        Trip trip = new Trip();
        trip.setPromoted(false);
        trip.setCheckoutFromHotel(new Date(request.getTripDetails().getToDate().getTime()));
        trip.setCheckinToHotel(new Date(request.getTripDetails().getFromDate().getTime()));
        trip.setFlightIdDeparture(departureFlight);
        trip.setFlightIdReturn(returnFlight);
        trip.setHotel(hotel);
        Trip savedTrip = tripDao.save(trip);

/*        hotel.getListOfTrips().add(savedTrip);
        departureFlight.getListOfReturnTrips().add(savedTrip);
        departureFlight.getListOfDepartureTrips().add(savedTrip);
        returnFlight.getListOfReturnTrips().add(savedTrip);
        returnFlight.getListOfDepartureTrips().add(savedTrip);*/

        return savedTrip.getId();
    }


    /*cross origin resourcer, database replication, load balancing (nginx), high available, provisioning tools, service discovery (consul, eureka),
     elk (elastic seach log stash and kebana), spring cqrs
    * partra de containerezare, service bus, (eip) enterprice integration pattern, cozi de mesaje  (amqp, jms), quartz, */

}
