package sda.tema.SDA_Tema_4.repository.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.repository.entitys.Hotel;

import java.util.Optional;

@Repository
public interface HotelDao extends CrudRepository<Hotel, Long> {

    Optional<Hotel> findByNameAndCityName(String hotelName, String cityName);

}
