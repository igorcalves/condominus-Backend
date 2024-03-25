package br.com.condominus.Condominus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominus.Condominus.domain.Areas;
import br.com.condominus.Condominus.repositories.AreasRepository;

@Service
public class AreasService {

    @Autowired
    AreasRepository repository;


    public List<Areas> findAllAreas(){
        return repository.findAll();
   
    }


    
    
}
