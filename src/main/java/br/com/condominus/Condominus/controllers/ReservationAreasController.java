package br.com.condominus.Condominus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condominus.Condominus.domain.ReservationAreas;
import br.com.condominus.Condominus.services.ReservationAreasService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("ra")
public class ReservationAreasController {

    @Autowired
    private ReservationAreasService service;
    

    @GetMapping
    public ResponseEntity<List<ReservationAreas>> findAllReservationsAreas(){
        return ResponseEntity.ok(service.findAllReservationsAreas());

    }

    
    
}
