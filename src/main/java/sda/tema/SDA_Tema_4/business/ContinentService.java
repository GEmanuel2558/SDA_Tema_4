package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.ContinentDtoResponse;
import sda.tema.SDA_Tema_4.repository.dao.ContinentDao;
import sda.tema.SDA_Tema_4.repository.entitys.Continent;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true)
public class ContinentService {

    private final ContinentDao continentDao;

    public ContinentService(ContinentDao continentDao) {
        this.continentDao = continentDao;
    }

    public List<ContinentDtoResponse> getAllContinents() {
        return StreamSupport.stream(this.continentDao.findAll().spliterator(), false).map(ContinentDtoResponse::new).collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Long insertNewContinent(final ContinentDtoResponse continentDtoResponse) {
        return continentDao.save(dtoToContity(continentDtoResponse)).getId();
    }

    private Continent dtoToContity(final ContinentDtoResponse continentDtoResponse) {
        Continent continent = new Continent();
        continent.setName(continentDtoResponse.getName());
        //continent.setListOfCountries();
        return continent;
    }

}
