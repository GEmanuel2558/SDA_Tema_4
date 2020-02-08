package sda.tema.SDA_Tema_4.repository.entitys;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Continent", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"}, name = "Numele continentului trebuie sa fie unic")
})
public class Continent extends BaseEntity {

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "continent")
    private List<Country> listOfCountries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getListOfCountries() {
        return listOfCountries;
    }

    public void setListOfCountries(List<Country> listOfCountries) {
        this.listOfCountries = listOfCountries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Continent continent = (Continent) o;
        return Objects.equals(name, continent.name) &&
                Objects.equals(listOfCountries, continent.listOfCountries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, listOfCountries);
    }

    @Override
    public String toString() {
        return "Continent{" +
                "name='" + name + '\'' +
                ", listOfCountries=" + listOfCountries +
                '}';
    }
}
