package sda.tema.SDA_Tema_4.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.repository.entitys.TripDetails;

@Repository
public interface TripDetailsDao extends PagingAndSortingRepository<TripDetails, Long> {
}
