package sda.tema.SDA_Tema_4.repository.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TripDao extends CrudRepository<Trip, Long> {

    @Query("select t from Trip t " +
            "inner join Room r on r.hotel = t.hotel " +
            "where (:departureDate is null or t.checkinFromHotel >= :departureDate )" +
            "and (:returnDate is null or t.checkoutFromHotel <= :returnDate )" +
            "and ( :hotelName is null or t.hotel.name = :hotelName )" +
            "and ( :cityName is null or t.hotel.city.name = :cityName )" +
            "and ( :nrOfPersons is null or r.numberOfAvailableDoubleRoom >= :nrOfPersons or r.numberOfAvailableSingleRoom >= :nrOfPersons )" +
            "order by t.checkinFromHotel asc")
    List<Trip> findTripByCriteria(@Param("departureDate") Date departureDate,
                                  @Param("returnDate") Date returnDate,
                                  @Param("hotelName") String hotelName,
                                  @Param("cityName") String cityName,
                                  @Param("nrOfPersons") Integer nrOfPersons);

    @Query(value = "select t from Trip t where " +
            "t.hotel.name = :hotelName " +
            "and t.flightIdDeparture.flightNumber = :departureFlightNumber " +
            "and t.flightIdReturn.flightNumber = :returnFlightNumber")
    Optional<Trip> findTripIdByCriteria(@Param("hotelName") String hotelName,
                                        @Param("departureFlightNumber") String departureFlightNumber,
                                        @Param("returnFlightNumber") String returnFlightNumber);

}
