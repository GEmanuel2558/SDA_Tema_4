package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import sda.tema.SDA_Tema_4.repository.dao.CityDao;
import sda.tema.SDA_Tema_4.repository.entitys.City;

import java.util.Optional;

@Service
public class CityService {

    private final CityDao cityDao;

    public CityService(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public Optional<City> findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

}
