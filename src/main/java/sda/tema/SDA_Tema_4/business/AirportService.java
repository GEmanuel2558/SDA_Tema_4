package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import sda.tema.SDA_Tema_4.repository.dao.AirportDao;
import sda.tema.SDA_Tema_4.repository.entitys.Airport;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportDao airportDao;

    public AirportService(AirportDao airportDao) {
        this.airportDao = airportDao;
    }

    public Optional<Airport> findAirportByName(@NotNull String airpotName) {
        return this.airportDao.findAllByName(airpotName);
    }

}
