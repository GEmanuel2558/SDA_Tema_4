package sda.tema.SDA_Tema_4.controller.web.payload;

import java.io.Serializable;

public class AirportDetails implements Serializable {

    private String name;
    private String cityName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
