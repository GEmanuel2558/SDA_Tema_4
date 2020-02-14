package sda.tema.SDA_Tema_4.repository.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.repository.entitys.City;

import java.util.Optional;

@Repository
public interface CityDao extends CrudRepository<City, Long> {

    Optional<City> findByName(String cityName);

}
