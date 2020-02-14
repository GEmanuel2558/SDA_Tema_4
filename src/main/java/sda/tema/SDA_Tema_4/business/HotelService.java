package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.HotelDetails;
import sda.tema.SDA_Tema_4.exceptions.NoHotelException;
import sda.tema.SDA_Tema_4.repository.dao.HotelDao;
import sda.tema.SDA_Tema_4.repository.entitys.Hotel;

@Service
public class HotelService {

    private final HotelDao hotelDao;

    public HotelService(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Hotel getHotel(HotelDetails hotelDetails) {
        return hotelDao.findByNameAndCityName(hotelDetails.getHotelName(), hotelDetails.getCityName())
                .orElseThrow(NoHotelException::new);
    }
}
