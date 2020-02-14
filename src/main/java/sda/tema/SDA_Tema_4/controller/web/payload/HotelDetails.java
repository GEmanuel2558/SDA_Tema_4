package sda.tema.SDA_Tema_4.controller.web.payload;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class HotelDetails implements Serializable {
    @NotNull
    private String cityName;
    @NotNull
    private String hotelName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

}
