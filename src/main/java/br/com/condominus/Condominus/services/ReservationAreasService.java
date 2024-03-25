package br.com.condominus.Condominus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominus.Condominus.domain.ReservationAreas;
import br.com.condominus.Condominus.mapper.ModelMapperConverter;
import br.com.condominus.Condominus.repositories.ReservationAreasRepository;

@Service
public class ReservationAreasService {

    @Autowired
    ReservationAreasRepository repository;


    public List<ReservationAreas> findAllReservationsAreas(){
        return repository.findAll();
   
    }


    
    
}
