package sda.tema.SDA_Tema_4.controller.web.payload;

import sda.tema.SDA_Tema_4.repository.entitys.City;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class CityDto implements Serializable {

    private String name;
    private CountryDto country;
    private List<HotelDto> listOfHotels;
    private List<AirportDto> listOfAirports;

    public CityDto() {

    }

    public CityDto(final City city) {
        this.name = city.getName();
        country = new CountryDto(city.getCountry());
        listOfAirports = city.getListOfAirports().stream().map(AirportDto::new).collect(Collectors.toList());
        listOfHotels = city.getListOfHotels().stream().map(HotelDto::new).collect(Collectors.toList());
    }

}
