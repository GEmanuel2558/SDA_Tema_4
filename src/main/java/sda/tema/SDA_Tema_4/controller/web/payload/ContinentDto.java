package sda.tema.SDA_Tema_4.controller.web.payload;

import sda.tema.SDA_Tema_4.repository.entitys.Continent;

import java.io.Serializable;

public class ContinentDto implements Serializable {

    private String name;

    public ContinentDto(final Continent continent) {
        this.name = continent.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
