package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.repository.dao.TripDetailsDao;
import sda.tema.SDA_Tema_4.repository.entitys.TripDetails;

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

}
