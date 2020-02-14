package sda.tema.SDA_Tema_4.repository.entitys;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Flight")
public class Flight extends BaseEntity {

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "departure_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;

    @Column(name = "number_of_seets")
    private Integer totalNumberOfSeets;

    @Column(name = "retailabe_seats", columnDefinition = "INT check (retailabe_seats > 0)")
    private Integer retailabeSeats;

    @Column(name = "flight_price")
    private Integer flightPrice;

    @ManyToOne
    @JoinColumn(name = "airport_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_flight_airport"))
    private Airport airport;

    @OneToMany(mappedBy = "flightIdDeparture")
    private List<Trip> listOfDepartureTrips;

    @OneToMany(mappedBy = "flightIdReturn")
    private List<Trip> listOfReturnTrips;

    @Version
    public Integer version;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getTotalNumberOfSeets() {
        return totalNumberOfSeets;
    }

    public void setTotalNumberOfSeets(Integer totalNumberOfSeets) {
        this.totalNumberOfSeets = totalNumberOfSeets;
    }

    public Integer getRetailabeSeats() {
        return retailabeSeats;
    }

    public void setRetailabeSeats(Integer retailabeSeats) {
        this.retailabeSeats = retailabeSeats;
    }

    public Integer getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(Integer flightPrice) {
        this.flightPrice = flightPrice;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public List<Trip> getListOfDepartureTrips() {
        return listOfDepartureTrips;
    }

    public void setListOfDepartureTrips(List<Trip> listOfDepartureTrips) {
        this.listOfDepartureTrips = listOfDepartureTrips;
    }

    public List<Trip> getListOfReturnTrips() {
        return listOfReturnTrips;
    }

    public void setListOfReturnTrips(List<Trip> listOfReturnTrips) {
        this.listOfReturnTrips = listOfReturnTrips;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightNumber, flight.flightNumber) &&
                Objects.equals(departureDate, flight.departureDate) &&
                Objects.equals(totalNumberOfSeets, flight.totalNumberOfSeets) &&
                Objects.equals(retailabeSeats, flight.retailabeSeats) &&
                Objects.equals(flightPrice, flight.flightPrice) &&
                Objects.equals(airport, flight.airport) &&
                Objects.equals(listOfDepartureTrips, flight.listOfDepartureTrips) &&
                Objects.equals(listOfReturnTrips, flight.listOfReturnTrips) &&
                Objects.equals(version, flight.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flightNumber, departureDate, totalNumberOfSeets, retailabeSeats, flightPrice, airport, listOfDepartureTrips, listOfReturnTrips, version);
    }
}
