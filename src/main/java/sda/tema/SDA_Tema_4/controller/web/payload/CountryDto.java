package sda.tema.SDA_Tema_4.controller.web.payload;

import sda.tema.SDA_Tema_4.repository.entitys.Country;

import java.io.Serializable;
import java.util.Objects;

public class CountryDto implements Serializable {

    private String name;
    private ContinentDto continent;

    public CountryDto(final Country country) {
        this.name = country.getName();
        continent = new ContinentDto(country.getContinent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContinentDto getContinent() {
        return continent;
    }

    public void setContinent(ContinentDto continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto that = (CountryDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(continent, that.continent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, continent);
    }
}
