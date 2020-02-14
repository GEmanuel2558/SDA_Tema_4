package sda.tema.SDA_Tema_4.repository.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.business.models.CustomRoomEntity;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TripDao extends PagingAndSortingRepository<Trip, Long> {

    @Query("select t from Trip t " +
            "inner join Room r on r.hotel = t.hotel " +
            "where (:departureDate is null or t.checkinToHotel >= :departureDate )" +
            "and ( :returnDate is null or t.checkoutFromHotel <= :returnDate )" +
            "and ( :hotelName is null or t.hotel.name = :hotelName )" +
            "and ( :cityName is null or t.hotel.city.name = :cityName )" +
            "group by t.checkinToHotel, t.checkoutFromHotel " +
            "having sum(2*r.numberOfAvailableDoubleRoom + r.numberOfAvailableSingleRoom + r.numberOfExtraBeds) >= :nrOfPersons " +
            "order by t.checkinToHotel, t.promoted asc")
    List<Trip> findTripByCriteria(@Param("departureDate") Date departureDate,
                                  @Param("returnDate") Date returnDate,
                                  @Param("hotelName") String hotelName,
                                  @Param("cityName") String cityName,
                                  @Param("nrOfPersons") Long nrOfPersons);

    @Query(value = "select t from Trip t where " +
            "t.hotel.name = :hotelName " +
            "and t.flightIdDeparture.flightNumber = :departureFlightNumber " +
            "and t.flightIdReturn.flightNumber = :returnFlightNumber")
    Optional<List<Trip>> findTripIdByCriteria(@Param("hotelName") String hotelName,
                                        @Param("departureFlightNumber") String departureFlightNumber,
                                        @Param("returnFlightNumber") String returnFlightNumber);




}
