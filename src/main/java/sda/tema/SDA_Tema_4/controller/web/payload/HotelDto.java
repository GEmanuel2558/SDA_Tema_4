package sda.tema.SDA_Tema_4.controller.web.payload;

import sda.tema.SDA_Tema_4.repository.entitys.Hotel;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class HotelDto implements Serializable {

    private String name;
    private String description;
    private Integer standard;
    private List<RoomDto> listOfRooms;

    public HotelDto() {
    }

    public HotelDto(final Hotel hotel) {
        name = hotel.getName();
        description = hotel.getDescription();
        standard = hotel.getStandard();
        listOfRooms = hotel.getListOfRooms().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public List<RoomDto> getListOfRooms() {
        return listOfRooms;
    }

    public void setListOfRooms(List<RoomDto> listOfRooms) {
        this.listOfRooms = listOfRooms;
    }
}
