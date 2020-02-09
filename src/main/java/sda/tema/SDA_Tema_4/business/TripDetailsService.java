package sda.tema.SDA_Tema_4.business;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDetailsDto;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDtoResponse;
import sda.tema.SDA_Tema_4.repository.dao.TripDetailsDao;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;
import sda.tema.SDA_Tema_4.repository.entitys.TripDetails;
import sda.tema.SDA_Tema_4.security.entitys.User;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripDetailsService {

    private final TripDetailsDao dao;

    public TripDetailsService(TripDetailsDao dao) {
        this.dao = dao;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Long insertNewTripDetails(TripDetails tripDetails) {
        return dao.save(tripDetails).getId();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Long insertNewTripDetails(TripDtoResponse buyTicket, Trip trip, User currentUser) {
        TripDetails tripDetails = new TripDetails();
        tripDetails.setTrip(trip);
        tripDetails.setCreatedRow(new Date(System.currentTimeMillis()));
        tripDetails.setExtraBed(0 == buyTicket.getExtraBed());
        tripDetails.setAmount(buyTicket.getAmount());
        tripDetails.setNumberOfDoubleRooms(buyTicket.getNumberOfDoubleRooms());
        tripDetails.setNumberOfSingleRooms(buyTicket.getNumberOfSingleRooms());
        tripDetails.setListOfUsers(Collections.singletonList(currentUser));
        return dao.save(tripDetails).getId();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public Optional<TripDetailsDto> getTripDetailsById(Long tripDetailsId) {
        return dao.findById(tripDetailsId).map(this::convertFromTripDetailsToDto);
    }


    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public Optional<List<TripDetailsDto>> getTripDetails(Pageable pageable) {
        return Optional.of(this.dao
                .findAll(pageable)
                .stream()
                .map(this::convertFromTripDetailsToDto)
                .collect(Collectors.toList()));
    }

    private TripDetailsDto convertFromTripDetailsToDto(TripDetails tripDetails) {
        TripDetailsDto tripDetailsDto = new TripDetailsDto();
        tripDetailsDto.setTripId(tripDetails.getId());
        tripDetailsDto.setCreatedRow(tripDetails.getCreatedRow().toString());
        tripDetailsDto.setAmount(tripDetails.getAmount());
        tripDetailsDto.setExtraBed(tripDetails.getExtraBed());
        tripDetailsDto.setNumberOfDoubleRooms(tripDetails.getNumberOfDoubleRooms());
        tripDetailsDto.setNumberOfSingleRooms(tripDetails.getNumberOfSingleRooms());
        return tripDetailsDto;
    }

}
