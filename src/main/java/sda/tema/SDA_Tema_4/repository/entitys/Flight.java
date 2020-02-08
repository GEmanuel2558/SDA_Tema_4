package sda.tema.SDA_Tema_4.repository.entitys;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @Column(name = "retailabe_seats")
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

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flight_number) {
        this.flightNumber = flight_number;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departure_date) {
        this.departureDate = departure_date;
    }

    public Integer getTotalNumberOfSeets() {
        return totalNumberOfSeets;
    }

    public void setTotalNumberOfSeets(Integer total_number_of_seets) {
        this.totalNumberOfSeets = total_number_of_seets;
    }

    public Integer getRetailabeSeats() {
        return retailabeSeats;
    }

    public void setRetailabeSeats(Integer retailabe_seats) {
        this.retailabeSeats = retailabe_seats;
    }

    public Integer getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(Integer flight_price) {
        this.flightPrice = flight_price;
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
}
