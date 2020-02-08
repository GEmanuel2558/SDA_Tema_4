package sda.tema.SDA_Tema_4.repository.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.repository.entitys.Airport;

@Repository
public interface AirportDao extends CrudRepository<Airport, Long> {
}
