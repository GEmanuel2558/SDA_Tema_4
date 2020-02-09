package sda.tema.SDA_Tema_4.controller.web.payload;

import sda.tema.SDA_Tema_4.repository.entitys.Airport;

import java.io.Serializable;

public class AirportDto implements Serializable {

    private String name;

    public AirportDto(final Airport airport) {
        this.name = airport.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
