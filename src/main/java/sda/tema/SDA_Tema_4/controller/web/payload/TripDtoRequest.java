package sda.tema.SDA_Tema_4.controller.web.payload;

import java.io.Serializable;
import java.sql.Date;

public class TripDtoRequest implements Serializable {

    private Date toDate;
    private Date fromDate;
    private String cityName;
    private String hotelName;
    private Integer nrOfPersons;

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

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

    public Integer getNrOfPersons() {
        if (null == nrOfPersons) {
            return 0;
        } else {
            return nrOfPersons;
        }
    }

    public void setNrOfPersons(Integer nrOfPersons) {
        this.nrOfPersons = nrOfPersons;
    }

    public boolean hasAtLeastOnePropertySet() {
        return null != toDate || null != fromDate || null != cityName || null != hotelName || null != nrOfPersons;
    }

}
