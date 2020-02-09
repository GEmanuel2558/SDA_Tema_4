package sda.tema.SDA_Tema_4.repository.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.repository.entitys.Airport;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportDao extends CrudRepository<Airport, Long> {

    Optional<Airport> findAllByName(String aitportName);


}
