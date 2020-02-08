package sda.tema.SDA_Tema_4.repository.entitys;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Country")
public class Country extends BaseEntity {

    @Column(unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "continent_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_continent_country"))
    private Continent continent;

    @OneToMany(mappedBy = "country")
    private List<City> listOfCities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public List<City> getListOfCities() {
        return listOfCities;
    }

    public void setListOfCities(List<City> listOfCities) {
        this.listOfCities = listOfCities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) &&
                Objects.equals(continent, country.continent) &&
                Objects.equals(listOfCities, country.listOfCities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, continent, listOfCities);
    }

    @Override
    public String toString() {
        //                ", listOfCities=" + listOfCities +
        return "Country{" +
                "name='" + name + '\'' +
                ", continent=" + continent +
                '}';
    }
}
