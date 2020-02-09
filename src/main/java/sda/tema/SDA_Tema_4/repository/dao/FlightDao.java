package sda.tema.SDA_Tema_4.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.repository.entitys.Flight;

import java.util.Optional;

@Repository
public interface FlightDao extends PagingAndSortingRepository<Flight, Long> {

    Optional<Flight> findByFlightNumber(String flightNumber);

}
