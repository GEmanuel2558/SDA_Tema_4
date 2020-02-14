package sda.tema.SDA_Tema_4.repository.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.repository.entitys.Flight;

import java.util.Optional;

@Repository
public interface FlightDao extends PagingAndSortingRepository<Flight, Long> {

    @Query(value = "select f from Flight f where f.flightNumber = :flightNumber")
    Optional<Flight> findByFlightNumber(@Param("flightNumber") String flightNumber);

}
